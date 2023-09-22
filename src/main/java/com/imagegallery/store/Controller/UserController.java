package com.imagegallery.store.Controller;
import com.imagegallery.store.DTO.*;
import com.imagegallery.store.Model.ImageInfo;
import com.imagegallery.store.Model.RootUser;
import com.imagegallery.store.Model.User;
import com.imagegallery.store.Repo.ImageinfoRepo;
import com.imagegallery.store.Repo.RegistrationRepo;
import com.imagegallery.store.Response.*;
import com.imagegallery.store.Service.FileService;
import com.imagegallery.store.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@RestController
public class UserController {
    @Value("${project.image}")
    private String path;
    @Autowired(required = true)
    private RegistrationRepo registrationRepo;
    @Autowired(required = true)
    private RegistrationService registrationService;
    @Autowired(required = true)
    private FileService fileService;
    @Autowired(required = true)
    private ImageinfoRepo imageinfoRepo;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/user/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDTO registrationDTO) {
        RegistrationResponse registrationResponse = registrationService.RegisterUser(registrationDTO);
        return ResponseEntity.ok(registrationResponse);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/specificuserinfo")
    public User getTreeById(@RequestParam("email") String email) {
        User userInfo = registrationRepo.findByEmail(email);
        userInfo.getUsername();
        userInfo.getUserid();
        userInfo.getMobilenumber();
        return userInfo;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/user/update")
    public ResponseEntity<?> update(@RequestBody RegistrationDTO registrationDTO) {
        RegistrationResponse registrationResponse = registrationService.UpdateUser(registrationDTO);
        return ResponseEntity.ok(registrationResponse);
    }
    // add image - post
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public String addImagePost(HttpServletRequest request, @RequestParam("useremail") String useremail, @RequestParam("image") MultipartFile file) throws IOException, SerialException, SQLException
    {
        byte[] bytes = file.getBytes();
        System.out.println("image byte array" + bytes);
        String encodedString = Base64
                .getEncoder()
                .encodeToString(bytes);
        System.out.println("image encoded to the array " + encodedString);
        User image = registrationRepo.findByEmail(useremail);
        image.setImage(encodedString);
        registrationService.create(image);
        return "Success";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/user/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = registrationService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


    @PostMapping(path = "/user/forgot")
    public ResponseEntity<?> sendOTP(@RequestBody ForgotDTO forgotDTO) {
        ForgotResponse response = registrationService.forgotUser(forgotDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/user/verify")
    public ResponseEntity<?> verifyOTP(@RequestBody OTPDTO otpdto) {
        OTPResponse otpResponse = registrationService.userOTP(otpdto);
        return ResponseEntity.ok(otpResponse);
    }

    @PostMapping(path = "/user/setnewpassword")
    public ResponseEntity<?> setNewPassword(@RequestBody NewPasswordDTO newPasswordDTO) {
        OTPResponse otpResponse = registrationService.newPassword(newPasswordDTO);
        return ResponseEntity.ok(otpResponse);
    }

    @PostMapping(path = "/user/imageinfo")
    public ResponseEntity<?> imageInfo(@RequestParam("imagename") MultipartFile file, String email, String title, String description) throws IOException {
        FileResponse fileResponse = this.fileService.uploadImage(path, file, email, title, description);
        return ResponseEntity.ok(fileResponse);
    }

    //Data fetch for unauthenticated user.
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/all/user")
    public ResponseEntity<?> imageInfo() throws IOException {
        List<ImageInfo> fileResponse = imageinfoRepo.findAll();
//        StringUtils.cleanPath()
        return ResponseEntity.ok(fileResponse);
    }
    //for authenticated users
    @GetMapping(path = "/user/auth")
    public ResponseEntity<?> authenticatedUser(@RequestParam("useremail") String useremail) {
        List<ImageInfo> fileResponse =  imageinfoRepo.findOneByEmail(useremail);
        return ResponseEntity.ok(fileResponse);
    }
}
