package com.imagegallery.store.Service.implementation;
import com.imagegallery.store.DTO.ImageStoreDTO;
import com.imagegallery.store.Model.ImageInfo;
import com.imagegallery.store.Repo.ImageinfoRepo;
import com.imagegallery.store.Repo.LoginRepository;
import com.imagegallery.store.Repo.RegistrationRepo;
import com.imagegallery.store.Response.FileResponse;
import com.imagegallery.store.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.Registration;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@Service
public class FileServiceImplementation implements FileService {
    @Value("${project.image}") //define the image folder in this project.
    private String path;
    @Autowired(required = true)
    private ImageinfoRepo imageinfoRepo;
    @Override
    public FileResponse uploadImageInfo(ImageStoreDTO imageStoreDTO) throws UncheckedIOException, IOException {
        String filename = imageStoreDTO.getImagename().getOriginalFilename();
        Random rnd = new Random();
        int generatedPath = rnd.nextInt(999999);
        String filepath = this.path + File.separator+generatedPath + filename;
        File f = new File(this.path);
        if (!f.exists()){
            f.mkdir();
        }
        Files.copy(imageStoreDTO.getImagename().getInputStream(), Paths.get(filepath));
        ImageInfo imageInfo = new ImageInfo(
                filepath,
                imageStoreDTO.getImagetitle(),
                imageStoreDTO.getImagedescription(),
                imageStoreDTO.getUseremail()
        );
        imageinfoRepo.save(imageInfo);
        return new FileResponse("File sent successful",true);
    }
}
