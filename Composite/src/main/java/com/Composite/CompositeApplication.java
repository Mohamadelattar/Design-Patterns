package com.Composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompositeApplication.class, args);
		Component product1 = new Product("Product_01");
		Component product2 = new Product("Product_02");
		Category category01 = new Category("category01");
		Category category02 = new Category("category02");
		Category category3 = new Category("category3");
		Category category1 = new Category("category1");

		category1.addComponent(product1);
		category1.addComponent(category01);
		category1.addComponent(category02);
		category02.addComponent(category3);
		category3.addComponent(product2);

		category1.printComponentName();

		category02.removeComponent(category3);
		 
		category1.printComponentName();
	}

}
