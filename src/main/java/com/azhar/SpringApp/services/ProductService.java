package com.azhar.SpringApp.services;

import com.azhar.SpringApp.config.Database;
import com.azhar.SpringApp.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    Database db;

    public void addProduct(Product p) {
        db.save(p);
    }

    public void addProducts(List<Product> p) {
        db.saveAll(p);
    }

    public List<Product> getAllProducts() {
        return db.findAll();
    }

    public Optional<Product> getProductByName(String name) {
        return db
                .findAll()
                .stream()
                .filter(prod -> name.equalsIgnoreCase(prod.getName()))
                .findFirst();
    }

    public List<Product> getProductsWithText(String text) {
        String lowerCaseSearchTerm = text.toLowerCase();

        return db
                .findAll()
                .stream()
                .filter(prod ->
                        prod.getName().toLowerCase().contains(lowerCaseSearchTerm)
                                || prod.getPlace().toLowerCase().contains(lowerCaseSearchTerm)
                                || prod.getType().toLowerCase().contains(lowerCaseSearchTerm)
                )
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPlace(String place) {
        return db
                .findAll()
                .stream()
                .filter(prod -> place.equalsIgnoreCase(prod.getPlace()))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsOutOfWarranty() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        return db
                .findAll()
                .stream()
                .filter(prod -> prod.getWarranty() < currentYear)
                .collect(Collectors.toList());
    }


}
