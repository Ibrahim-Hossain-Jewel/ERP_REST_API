package com.imagegallery.store.Repo;

import com.imagegallery.store.Model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<OrderTable, Long> {
    @Query(value = "SELECT * FROM storegallery.ordertable where customeremail =:customeremail", nativeQuery = true)
    List<OrderTable> findOneByEmail(@Param("customeremail") String customeremail);
//    Date orderdatetoday = new Date();
    @Query(value = "SELECT * FROM  storegallery.ordertable where Date(orderdate) =:orderdatetoday", nativeQuery = true)
    List<OrderTable> findByorderdate(LocalDate orderdatetoday);

    @Query(value = "SELECT * FROM storegallery.ordertable where Date(orderdate) BETWEEN :fromdate AND :todate", nativeQuery = true)
    List<OrderTable> findByorderdate(String fromdate, String todate);
}
