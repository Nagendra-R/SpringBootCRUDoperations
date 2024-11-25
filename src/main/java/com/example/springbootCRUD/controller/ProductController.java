package com.example.springbootCRUD.controller;

import com.example.springbootCRUD.entity.ErrorResponse;
import com.example.springbootCRUD.entity.Product;
import com.example.springbootCRUD.exception.ProductNotFoundException;
import com.example.springbootCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.time.LocalTime;
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


    @GetMapping("byId/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int productId){

//        try{
            Product product = productService.getProductById(productId).
                    orElseThrow(() -> new ProductNotFoundException("Product Not Found: " + productId));
            return ResponseEntity.ok(product);
//        }catch(ProductNotFoundException e){
//            ErrorResponse productNxotFound = new ErrorResponse(LocalTime.now(), e.getMessage(), "product not found");
//            return new ResponseEntity<>(productNotFound, HttpStatus.NOT_FOUND);
//        }


    }


    @PostMapping("add/")
    public Product addProduct(@RequestBody Product product){
         return productService.addProduct(product);
    }

    @PutMapping("updateProduct/{id}")
    public Product updateProductById(@RequestBody Product product, @PathVariable("id") int productId){
        return productService.updateProductById(product,productId);
    }

    @DeleteMapping("deleteProduct/{id}")
    public String deleteProductById(@PathVariable("id") int productId){

         return productService.deleteProductById(productId);
    }





    @GetMapping("getByName/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable("name") String pName){

//        try {
            Product product = productService.getProductByName(pName).orElseThrow(()->new ProductNotFoundException("product not found with: "+pName));
            return ResponseEntity.ok(product);
//        }catch(ProductNotFoundException e){
//            ErrorResponse errorResponse = new ErrorResponse(LocalTime.now(),e.getMessage(),"product not found with name");
//            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
//        }
    }







}
