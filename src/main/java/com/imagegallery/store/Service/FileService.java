package com.imagegallery.store.Service;

import com.imagegallery.store.Response.FileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    FileResponse uploadImage(String path, MultipartFile file, String email, String title, String description) throws IOException;
}
