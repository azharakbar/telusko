package com.azhar.SpringApp.services;

import com.azhar.SpringApp.config.Database;
import com.azhar.SpringApp.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final Database db;

    public void addProduct(Product p) {
        db.save(p);
    }

    public void addProducts(List<Product> p) {
        db.saveAll(p);
    }

    public List<Product> getAllProducts() {
        return db.findAll();
    }

    public Product getProductByName(String name) {
        Optional<Product> products =
                db
                    .findAll()
                    .stream()
                    .filter(prod -> name.equalsIgnoreCase(prod.getName()))
                    .findFirst();

        return products.isPresent() ? products.get() : null;
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

    public void createDummyProducts() {
        addProducts(List.of(new Product("Type C", "Cable", "Black Drawer", 2024),
                new Product("Mac Studio", "Computer", "White Table", 2025),
                new Product("Focusrite Mixer", "Audio System", "White Table", 2025),
                new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021),
                new Product("Asus Rog", "Laptop", "Black Table", 2021),
                new Product("Macbook pro", "Laptop", "Brown Drawer", 2022),
                new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020),
                new Product("Apple Keyboard", "Keyboard", "White Table", 2022),
                new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024),
                new Product("Hdmi cable", "Cable", "Black Drawer", 2024),
                new Product("Java Black Book", "Cable", "Shelf", 2024),
                new Product("Logi Mouse", "Mouse", "Black Table", 2022),
                new Product("Apple Mouse", "Mouse", "White Table", 2022),
                new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022),
                new Product("BlackBeast", "Computer", "White Table", 2020)));
    }


}
