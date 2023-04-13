package com.imagegallery.store.Controller;
import com.imagegallery.store.DTO.*;
import com.imagegallery.store.Model.User;
import com.imagegallery.store.Repo.RegistrationRepo;
import com.imagegallery.store.Response.ForgotResponse;
import com.imagegallery.store.Response.LoginResponse;
import com.imagegallery.store.Response.OTPResponse;
import com.imagegallery.store.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    @Autowired(required = false)
    private RegistrationRepo registrationRepo;
    @Autowired(required = false)
    private RegistrationService registrationService;
    @Autowired(required = false)
    private Random random;
    @GetMapping(value = "/jewel")
    public List<User>getTreeById() {
        return registrationRepo.findAll();
    }
    @PostMapping(path = "/user/registration")
    public String registration(@RequestBody RegistrationDTO registrationDTO){
        String id = registrationService.RegisterUser(registrationDTO);
        return  id;
    }
    @PostMapping(path = "/user/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = registrationService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
    @PostMapping(path = "/user/forgot")
    public ResponseEntity<?> sendOTP(@RequestBody ForgotDTO forgotDTO){
        ForgotResponse response =  registrationService.forgotUser(forgotDTO);
        return ResponseEntity.ok(response);
    }
    @PostMapping(path = "/user/verify")
    public ResponseEntity<?> verifyOTP(@RequestBody OTPDTO otpdto){
        OTPResponse otpResponse = registrationService.userOTP(otpdto);
        return ResponseEntity.ok(otpResponse);
    }
    @PostMapping(path = "/user/setnewpassword")
    public ResponseEntity<?> setNewPassword(@RequestBody NewPasswordDTO newPasswordDTO){
        OTPResponse otpResponse = registrationService.newPassword(newPasswordDTO);
        return ResponseEntity.ok(otpResponse);
    }

}