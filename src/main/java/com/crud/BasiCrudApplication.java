package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasiCrudApplication {

    // ANSI escape code for green color
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        SpringApplication.run(BasiCrudApplication.class, args);
        System.out.println(ANSI_GREEN + "✅ Application is running at http://localhost:8080" + ANSI_RESET);
    }
}
