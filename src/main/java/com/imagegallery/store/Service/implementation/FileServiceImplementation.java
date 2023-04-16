package com.imagegallery.store.Service.implementation;
import com.imagegallery.store.Model.ImageInfo;
import com.imagegallery.store.Model.User;
import com.imagegallery.store.Repo.ImageinfoRepo;
import com.imagegallery.store.Repo.LoginRepository;
import com.imagegallery.store.Response.FileResponse;
import com.imagegallery.store.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.io.*;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Random;

@Service
public class FileServiceImplementation implements FileService {
    @Autowired(required = true)
    private LoginRepository loginRepository;
    @Autowired(required = true)
    private ImageinfoRepo imageinfoRepo;
    @Autowired(required = true)
    private ImageInfo imageInfo;
    public FileResponse uploadImage(String path, MultipartFile file, String email, String title, String description) throws IOException {
        User dbEmailCheck = loginRepository.findByEmail(email);
        String DBEmail = dbEmailCheck.getEmail();
        String filename = file.getOriginalFilename();
        Random val = new Random();
        int randomNumber = val.nextInt(999999);
        String filePath = path + File.separator + randomNumber+filename;
        file.transferTo(Paths.get(filePath));
        if (Objects.equals(email, DBEmail)){
            System.out.println("Your is present in you database");
            ImageInfo imageInfo = new ImageInfo(
                filePath,
                    title,
                    description,
                    email
             );
            imageinfoRepo.save(imageInfo);
            return new FileResponse("Image data sent success",true);
        }else{
            return new FileResponse("You are not valid user", false);
        }
    }
}
