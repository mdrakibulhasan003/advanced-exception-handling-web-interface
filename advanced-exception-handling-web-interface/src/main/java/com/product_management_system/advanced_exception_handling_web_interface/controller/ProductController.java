package com.product_management_system.advanced_exception_handling_web_interface.controller;

import com.product_management_system.advanced_exception_handling_web_interface.exception.InvalidProductDataException;
import com.product_management_system.advanced_exception_handling_web_interface.exception.ProductNotFoundException;
import com.product_management_system.advanced_exception_handling_web_interface.model.Product;
import com.product_management_system.advanced_exception_handling_web_interface.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/new")
    public String showProductForm(Model model){
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "product-form";
        }
        try{
            Product product1 = productService.createProduct(product);
            model.addAttribute("product", product1);
            return "product-details";
        }
        catch (InvalidProductDataException ex){
            model.addAttribute("error", ex.getMessage());
            return "product-form";
        }
    }

    @GetMapping("/{id}")
    public String getProductByid(@PathVariable Long id, Model model){
        try{
            Product product = productService.getProductById(id);
            model.addAttribute("product", product);
            return "product-details";
        }
        catch(ProductNotFoundException ex){
            model.addAttribute("error", ex.getMessage());
            return "error";
        }
    }
}
