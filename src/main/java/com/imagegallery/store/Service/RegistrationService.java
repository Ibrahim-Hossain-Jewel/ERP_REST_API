package com.imagegallery.store.Service;
import com.imagegallery.store.DTO.*;
import com.imagegallery.store.Response.LoginResponse;
import com.imagegallery.store.Response.ForgotResponse;
import com.imagegallery.store.Response.OTPResponse;
import org.springframework.stereotype.Repository;
//Service allows to add business functionality in spring boot
@Repository
public interface RegistrationService {
    String RegisterUser(RegistrationDTO registrationDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
    ForgotResponse forgotUser(ForgotDTO forgotDTO);
    OTPResponse userOTP(OTPDTO otpdto);

    OTPResponse newPassword(NewPasswordDTO newPasswordDTO);
}
