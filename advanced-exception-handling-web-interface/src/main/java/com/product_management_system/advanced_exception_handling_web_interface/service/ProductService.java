package com.product_management_system.advanced_exception_handling_web_interface.service;

import com.product_management_system.advanced_exception_handling_web_interface.exception.InvalidProductDataException;
import com.product_management_system.advanced_exception_handling_web_interface.exception.ProductNotFoundException;
import com.product_management_system.advanced_exception_handling_web_interface.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProductById(Long id){
        if(id<=0){
            throw new ProductNotFoundException("Product not found with id: " +id);
        }
        Product product = new Product();
        product.setName("Sample Product "+id);
        product.setPrice(100*id);
        return product;
    }

    public Product createProduct (Product product){
        if(product.getPrice()>1000){
            throw new InvalidProductDataException("Product price cannot be greater than 1000");
        }
        return product;
    }
}
