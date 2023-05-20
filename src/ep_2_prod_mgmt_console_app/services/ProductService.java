package ep_2_prod_mgmt_console_app.services;

import ep_2_prod_mgmt_console_app.entities.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addProducts(List<Product> p) {
        products.addAll(p);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductByName(String name) {
        return products.stream().filter(prod -> name.equalsIgnoreCase(prod.getName())).findFirst();
    }

    public List<Product> getProductsWithText(String text) {
        String lowerCaseSearchTerm = text.toLowerCase();

        return products
                .stream()
                .filter(prod ->
                        prod.getName().toLowerCase().contains(lowerCaseSearchTerm)
                                || prod.getPlace().toLowerCase().contains(lowerCaseSearchTerm)
                                || prod.getType().toLowerCase().contains(lowerCaseSearchTerm)
                )
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPlace(String place) {
        return products
                .stream()
                .filter(prod -> place.equalsIgnoreCase(prod.getPlace()))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsOutOfWarranty() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        return products
                .stream()
                .filter(prod -> prod.getWarranty() < currentYear)
                .collect(Collectors.toList());
    }


}
