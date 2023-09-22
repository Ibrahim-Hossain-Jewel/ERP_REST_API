package com.imagegallery.store.Service.implementation;

import com.imagegallery.store.DTO.LoginDTO;
import com.imagegallery.store.Model.RootUser;
import com.imagegallery.store.Model.User;
import com.imagegallery.store.Repo.RootUserRepo;
import com.imagegallery.store.Response.LoginResponse;
import com.imagegallery.store.Service.RootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RootUserServiceImplementation implements RootUserService {

    @Autowired
    RootUserRepo rootUserRepo;
    //Implementing the login checker
    @Override
    public LoginResponse loginUser(LoginDTO loginDTO){
        //Find the email by the model
        RootUser user1 = rootUserRepo.findByrootemail(loginDTO.getEmail()); //If user not null.
        if(user1 != null){ //If user not null
            String password = loginDTO.getPassword();
            RootUser passwordNull = rootUserRepo.findByrootpassword(loginDTO.getPassword());
            try{
                if (password.equals(passwordNull.getRootpassword()) && passwordNull != null){
                    return new LoginResponse("Root user login success", true);
                }else{
                    return  new LoginResponse("Root password not found", false);
                }
            }catch (NullPointerException e){
                return new LoginResponse("Root password not match!", false);
            }
        }else {
            return new LoginResponse("Email does not exist", false);
        }
    }
    //End login response;
}
