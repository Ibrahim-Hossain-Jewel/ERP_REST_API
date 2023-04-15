package com.imagegallery.store.Repo;

import com.imagegallery.store.Model.ImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageinfoRepo extends JpaRepository<ImageInfo, Long> {
}
