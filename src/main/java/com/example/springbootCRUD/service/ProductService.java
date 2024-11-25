package com.example.springbootCRUD.service;

import com.example.springbootCRUD.entity.Product;
import com.example.springbootCRUD.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

//        List<Product> products = new ArrayList<>(Arrays.asList(
//                new Product(101,"laptop",30000),
//                new Product(102,"mouse",20000),
//                new Product(103,"phone",10000)
//        ));


    public List<Product> getProducts() {
//        return products;
        return productRepo.findAll();
    }


    public Optional<Product> getProductById(int productId) {
        return productRepo.findById(productId);
//        return products.stream().filter(product -> product.getProductId() == productId).findFirst().orElse(new Product(-1,"no product",0));
    }


    public Product addProduct(Product product) {
        return productRepo.save(product);

//        products.add(product);
//        return product;
    }


    public Product updateProductById(Product product, int productId) {

        Product existingProduct = productRepo.findById(productId).orElse(null);
//        assert existingProduct != null;
        assert existingProduct != null;
        existingProduct.setProductId(product.getProductId());
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());
        return productRepo.save(existingProduct);

//        int index =0;
//        for (int i = 0; i < products.size(); i++) {
//            if(products.get(i).getProductId() == productId){
//                index = i;
//            }
//        }
//
//        products.set(index,product);
    }

    public String deleteProductById(int productId) {
        productRepo.deleteById(productId);
        return "deleted product: "+productId;
//        int index =0;
//        for (int i = 0; i < products.size(); i++) {
//            if(products.get(i).getProductId() == productId){
//                index = i;
//            }
//        }
//
//        return products.remove(index);
    }


    public Optional<Product> getProductByName(String pName) {
         return productRepo.findByProductName(pName);
    }


}
