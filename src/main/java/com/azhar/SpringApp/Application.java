package com.azhar.SpringApp;

import com.azhar.SpringApp.entities.Product;
import com.azhar.SpringApp.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		ProductService service = context.getBean(ProductService.class);

		service.addProducts(List.of(new Product("Type C", "Cable", "Black Drawer", 2024),
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

		List<Product> products = service.getAllProducts();
		products.forEach(System.out::println);

		System.out.println("==============================================");

		System.out.println("a Particular product");

		Optional<Product> p = service.getProductByName("Logi Mofuse");
		if (p.isPresent()) {
			System.out.println(p.get());
		} else {
			System.out.println("Product not found with the name: Logi Mouse");
		}


		System.out.println("==============================================");

		System.out.println("a Particular text");

		List<Product> prods = service.getProductsWithText("black");
		prods.forEach(System.out::println);

		System.out.println("==============================================");

		System.out.println("Products on White Table");

		List<Product> prodsOnWhiteTable = service.getProductsByPlace("White Table");
		prodsOnWhiteTable.forEach(System.out::println);

		System.out.println("==============================================");

		service.addProduct(new Product("Keychron K4 V2", "Keyboard", "Computer Table", 2025));

		System.out.println("Products Out Of Warranty");

		List<Product> prodsOutOfWarranty = service.getProductsOutOfWarranty();

		prodsOutOfWarranty.forEach(System.out::println);


	}

}
