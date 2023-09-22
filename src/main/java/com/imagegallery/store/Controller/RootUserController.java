package com.imagegallery.store.Controller;
import com.imagegallery.store.DTO.LoginDTO;
import com.imagegallery.store.Model.RootUser;
import com.imagegallery.store.Model.User;
import com.imagegallery.store.Repo.RootUserRepo;
import com.imagegallery.store.Response.LoginResponse;
import com.imagegallery.store.Response.ProductsResponse;
import com.imagegallery.store.Service.RootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

@RestController
public class RootUserController {
    @Autowired
    RootUserRepo rootUserRepo;
    @Autowired(required = true)
    RootUserService rootUserService;
    //root user registration.
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/rootuserregistration")
    public ProductsResponse rootUserRegistration(HttpServletRequest request,
                                                 @RequestParam("rootusername") String rootusername,
                                                 @RequestParam("rootemail") String rootemail,
                                                 @RequestParam("rootpassword") String rootpassword,
                                                 @RequestParam("rootmobilenumber") String rootmobilenumber,
                                                 @RequestParam("rootaddress") String rootaddress,
                                                 @RequestParam("rootimage") MultipartFile file
    ) throws IOException, SerialException, SQLException
    {
        RootUser existUser = rootUserRepo.findByrootemail(rootemail);
        if (existUser == null ){
            byte[] bytes = file.getBytes();
            String encodedString = Base64
                    .getEncoder()
                    .encodeToString(bytes);
            RootUser addProducts = new RootUser(
                    rootusername,
                    rootemail,
                    rootpassword,
                    rootmobilenumber,
                    rootaddress,
                    encodedString
            );
            rootUserRepo.save(addProducts);
            return new ProductsResponse("Root User Created!", true);
        }
        else{
            return new ProductsResponse("Account already exist!", false);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/rootuser/login")
    public ResponseEntity<?> rootUserlogin(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = rootUserService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/specificrootuserinfo")
    public RootUser getTreeById(@RequestParam("email") String email) {
        RootUser userInfo = rootUserRepo.findByrootemail(email); //If user not null.
        userInfo.getRootusername();
        userInfo.getRootid();
        userInfo.getRootimage();
        userInfo.getRootmobilenumber();
        return userInfo;
    }

}
