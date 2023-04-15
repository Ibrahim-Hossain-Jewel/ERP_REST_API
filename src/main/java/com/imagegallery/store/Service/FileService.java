package com.imagegallery.store.Service;

import com.imagegallery.store.DTO.ImageStoreDTO;
import com.imagegallery.store.Response.FileResponse;

import java.io.IOException;
import java.io.UncheckedIOException;

public interface FileService {
    FileResponse uploadImageInfo(ImageStoreDTO imageStoreDTO) throws UncheckedIOException, IOException;
}
