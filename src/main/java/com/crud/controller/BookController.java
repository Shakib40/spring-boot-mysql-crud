package com.crud.controller;

import com.crud.dto.*;
import com.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Controller", description = "Operations related to books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @Operation(summary = "Create a new book")
    public CreateBookDto createBook(@Valid @RequestBody CreateBookDto createBookDto) {
        return bookService.createBook(createBookDto);
    }

    @GetMapping
    public List<ListBookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public CreateBookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public CreateBookDto updateBook(@PathVariable Long id, @RequestBody CreateBookDto createBookDto) {
        return bookService.updateBook(id, createBookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
