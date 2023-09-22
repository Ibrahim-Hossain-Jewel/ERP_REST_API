package com.imagegallery.store.Repo;

import com.imagegallery.store.Model.ProductsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.lang.Long;
@EnableJpaRepositories
@Repository
public interface ProductRepo extends JpaRepository<ProductsInfo, Long> {

}
