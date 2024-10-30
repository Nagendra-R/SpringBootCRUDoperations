package com.example.springbootCRUD.repository;

import com.example.springbootCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
