package com.imagegallery.store.Service;
import com.imagegallery.store.DTO.*;
import com.imagegallery.store.Model.User;
import com.imagegallery.store.Response.LoginResponse;
import com.imagegallery.store.Response.ForgotResponse;
import com.imagegallery.store.Response.OTPResponse;
import com.imagegallery.store.Response.RegistrationResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

//Service allows to add business functionality in spring boot
@Repository
public interface RegistrationService {
    RegistrationResponse RegisterUser(RegistrationDTO registrationDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
    ForgotResponse forgotUser(ForgotDTO forgotDTO);
    OTPResponse userOTP(OTPDTO otpdto);
    OTPResponse newPassword(NewPasswordDTO newPasswordDTO);
    //option for upload and fetch image
    public User create(User image);
    public List<User> viewAll();
    public User viewById(long id);

    RegistrationResponse UpdateUser(RegistrationDTO registrationDTO);
}
