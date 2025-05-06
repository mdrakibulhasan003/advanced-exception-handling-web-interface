package com.product_management_system.advanced_exception_handling_web_interface.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Product {

    //Product name with validation
    @NotBlank(message = "Product name cannot be empty")
    @Size(min = 3, max = 60, message = "Product name must be within 60 characters.")
    private String name;

    //Product price with min value
    @Min(value = 1, message = "Product price must be greater than 3")
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
