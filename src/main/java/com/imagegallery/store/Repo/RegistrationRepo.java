package com.imagegallery.store.Repo;
import com.imagegallery.store.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RegistrationRepo extends JpaRepository<User, Long>, LoginRepository {

}
