package com.example.springbootCRUD.controller;

import com.example.springbootCRUD.entity.Product;
import com.example.springbootCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") int productId){
        return productService.getProductById(productId);
    }


    @PostMapping("")
    public Product addProduct(@RequestBody Product product){
         return productService.addProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProductById(@RequestBody Product product,@PathVariable("id") int productId){
        return productService.updateProductById(product,productId);
    }

    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable("id") int productId){
         return productService.deleteProductById(productId);
    }

}
