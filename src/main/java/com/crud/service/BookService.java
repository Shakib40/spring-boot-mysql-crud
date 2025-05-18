package com.crud.service;
import com.crud.dto.BookDto;
import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    BookDto updateBook(Long id, BookDto bookDto);
    void deleteBook(Long id);
}
