package com.imagegallery.store.Repo;

import com.imagegallery.store.DTO.LoginDTO;
import com.imagegallery.store.Model.RootUser;
import com.imagegallery.store.Response.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RootUserRepo extends JpaRepository<RootUser, Long> {
    RootUser findByrootemail(String rootemail);

    RootUser findByrootpassword(String password);
}
