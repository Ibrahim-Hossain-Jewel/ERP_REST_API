package com.imagegallery.store.Service.implementation;
import com.imagegallery.store.Config.SecurityConfig;
import com.imagegallery.store.DTO.*;
import com.imagegallery.store.Model.User;
import com.imagegallery.store.Repo.LoginRepository;
import com.imagegallery.store.Repo.RegistrationRepo;
import com.imagegallery.store.Response.LoginResponse;
import com.imagegallery.store.Response.ForgotResponse;
import com.imagegallery.store.Response.OTPResponse;
import com.imagegallery.store.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.Random;

//Interface implementation helps to add business functionality
@Service
public class RegistrationImplementation implements RegistrationService {
    @Autowired(required = false)
    RegistrationRepo registrationRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    HttpSession session;
    @Override
    public String RegisterUser(RegistrationDTO registrationDTO) {
        //Passing the user DTO value to the domain object (JPA Entity)
        User user = new User(
                registrationDTO.getUserid(),
                registrationDTO.getUsername(),
                registrationDTO.getEmail(),
                this.passwordEncoder.encode(registrationDTO.getPassword())
        );
        registrationRepo.save(user);
        return user.getUsername();
    }
    //Implementing the login checker
    @Override
    public LoginResponse loginUser(LoginDTO loginDTO){
        String msg = "";
        //Extract the email by the model
        User user1 = loginRepository.findByEmail(loginDTO.getEmail()); //If user not null.
        if(user1 != null){ //If user not null
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword(); //find out the encoded password.user
            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);
            if (isPwdRight){
                Optional<User> user = loginRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(user.isPresent()){
                    return new LoginResponse("Login Success", true);
                }else {
                    return  new LoginResponse("Login Failed", false);
                }
            }else{
                return  new LoginResponse("Password not Match", false);
            }
        }else {
            return new LoginResponse("Email does not exist", false);
        }
    }
    //End login response;

    @Override
    public ForgotResponse forgotUser(ForgotDTO forgotDTO) {
        User user1 = loginRepository.findByEmail(forgotDTO.getEmail());
        //check the email it's presents or absents
        Random rnd = new Random();
        int myOTP = rnd.nextInt(999999);
        if (user1 != null){
            String to = user1.getEmail();
            String from = "ibrahimhossain495@gmail.com";
            String subject = "Your Image-Gallery OTP";
            String message = "OTP from Image-Gallery Application : <h1>"+myOTP + "</h1>";
            Boolean flag = securityConfig.sendMail(from, to, subject, message);
            if (flag){
                session.setAttribute("OTP",myOTP);
                return  new ForgotResponse("Check your E-mail "+ to, true);
            }else{
                return new ForgotResponse("your mail server down",false);
            }

        }else{
            return new ForgotResponse("E-mail doesn't exist ID ", false);
        }

    }

    @Override
    public OTPResponse userOTP(OTPDTO otpdto) {
        try {
            int userOTP = otpdto.getOtp();
            session.setAttribute("newOTP",userOTP);
            int emailOTP = (int)session.getAttribute("OTP");
            if (userOTP == emailOTP){
                //you can declare a variable to enable set new password.
                return new OTPResponse("Congratulation you can change your password",true);
            }else{
                return new OTPResponse("Your OTP doesn't match",false);
            }
        }catch (Exception e){
            return new OTPResponse("Wrong OTP "+e, false);
        }
    }

    @Override
    public OTPResponse newPassword(NewPasswordDTO newPasswordDTO) {
        String user1 = newPasswordDTO.getEmail();
        String user1Password = newPasswordDTO.getPassword();
        int emailOTP = (int)session.getAttribute("OTP");
        int newOTP = (int)session.getAttribute("newOTP");
        if (emailOTP == newOTP){
            User user2 = registrationRepo.findByEmail(newPasswordDTO.getEmail());
            user2.setPassword(this.passwordEncoder.encode(newPasswordDTO.getPassword()));
            registrationRepo.save(user2);
            return  new OTPResponse("New password set successful.", true);
        }else {
            return new OTPResponse("Your are wrong user", false);
        }
    }

}