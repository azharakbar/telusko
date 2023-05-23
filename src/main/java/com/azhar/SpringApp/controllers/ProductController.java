package com.azhar.SpringApp.controllers;


import com.azhar.SpringApp.entities.Product;
import com.azhar.SpringApp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public void createDummyProducts() {
        productService.createDummyProducts();
    }

    @GetMapping("/seaerch/name/{productName}")
    public Product getProductWithProductName(@PathVariable String productName) {
        return productService.getProductByName(productName);
    }

    @GetMapping("/search/wild-card/{searchText}")
    public List<Product> getProductWithWildcardSearch(@PathVariable String searchText) {
        return productService.getProductsWithText(searchText);
    }

    @GetMapping("/find/place/{place}")
    public List<Product> findProductsAtAPlace(@PathVariable String place) {
        return productService.getProductsByPlace(place);
    }

    @GetMapping("/out-of-warranty-products")
    public List<Product> getOutOfWarrantyProducts() {
        return productService.getProductsOutOfWarranty();
    }
}
