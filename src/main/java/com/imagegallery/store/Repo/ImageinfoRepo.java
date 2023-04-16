package com.imagegallery.store.Repo;
import com.imagegallery.store.Model.ImageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ImageinfoRepo extends JpaRepository<ImageInfo, Long> {
    @Query(value = "SELECT * FROM storegallery.imagestore where useremail =:useremail", nativeQuery = true)
    List<ImageInfo> findOneByEmail(@Param("useremail") String useremail);
}
