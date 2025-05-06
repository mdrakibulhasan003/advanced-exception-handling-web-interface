package com.product_management_system.advanced_exception_handling_web_interface.exception;

public class InvalidProductDataException extends RuntimeException{

    public InvalidProductDataException(String message) {
        super(message);
    }
}
