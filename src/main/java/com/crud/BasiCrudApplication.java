package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasiCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasiCrudApplication.class, args);
        System.out.println("✅ Basi-Crud Application is running at http://localhost:8080");
        System.out.println("🛠️  H2 Console available at: http://localhost:8080/h2-console");
    }
}
