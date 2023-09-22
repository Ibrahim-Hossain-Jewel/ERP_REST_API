package com.imagegallery.store.Service;

import com.imagegallery.store.DTO.LoginDTO;
import com.imagegallery.store.Response.LoginResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface RootUserService {
    LoginResponse loginUser(LoginDTO loginDTO);
}
