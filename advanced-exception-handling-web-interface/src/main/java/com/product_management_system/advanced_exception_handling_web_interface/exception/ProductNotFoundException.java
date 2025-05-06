package com.product_management_system.advanced_exception_handling_web_interface.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
