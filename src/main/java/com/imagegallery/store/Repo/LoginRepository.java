package com.imagegallery.store.Repo;
import com.imagegallery.store.Model.User;
import java.util.Optional;

public interface LoginRepository {
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
