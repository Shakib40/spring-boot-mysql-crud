package com.crud.service;
import com.crud.dto.*;
import java.util.List;


public interface BookService {
	CreateBookDto createBook(CreateBookDto createBookDto);
    List<ListBookDto> getAllBooks();
    CreateBookDto getBookById(Long id);
    CreateBookDto updateBook(Long id, CreateBookDto createBookDto);
    void deleteBook(Long id);
}
