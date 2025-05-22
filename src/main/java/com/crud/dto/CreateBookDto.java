package com.crud.dto;
import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.validation.constraints.*;
import com.crud.entity.Book;

public class CreateBookDto {
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    @Size(min = 1, max = 255, message = "Author must be between 1 and 255 characters")
    private String author;

    @NotNull(message = "Price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Double price;
    
    
    @LastModifiedDate
    private LocalDateTime publishDate;
   
    
    public CreateBookDto() {}
 // DTO constructor from Entity
    public CreateBookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
        this.publishDate = book.getPublishDate();
    }
    
 
    

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
   
	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}
 
}
