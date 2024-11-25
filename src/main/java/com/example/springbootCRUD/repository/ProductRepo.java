package com.example.springbootCRUD.repository;

import com.example.springbootCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "select p from Product p where productName=:val")
    Optional<Product> findByProductName(@Param("val") String name);



}
