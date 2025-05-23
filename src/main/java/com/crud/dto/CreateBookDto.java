package com.crud.dto;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import com.crud.entity.Book;

public class CreateBookDto {
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters")
    private String author;
    
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private double price;

    @NotNull(message = "Publish date is required")
    @PastOrPresent(message = "Publish date can't be in the future")
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



