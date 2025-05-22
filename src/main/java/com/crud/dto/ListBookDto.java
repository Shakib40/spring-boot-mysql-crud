package com.crud.dto;

import com.crud.entity.Book;
import java.time.LocalDateTime;

public class ListBookDto {

    private Long id;
    private String title;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public ListBookDto() {
    }

    // Constructor to map from Book entity to DTO
    public ListBookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.createdDate = book.getCreatedDate();
        this.updatedDate = book.getUpdatedDate();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
