package com.crud.service;

import com.crud.dto.BookDto;
import com.crud.entity.Book;
import com.crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = new Book(bookDto);             // convert DTO to Entity
        Book savedBook = bookRepository.save(book);
        return new BookDto(savedBook);             // convert Entity to DTO
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookDto::new)                // constructor-based conversion
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookDto::new)
                .orElse(null);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        return bookRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(bookDto.getTitle());
                    existing.setAuthor(bookDto.getAuthor());
                    existing.setPrice(bookDto.getPrice());
                    Book updated = bookRepository.save(existing);
                    return new BookDto(updated);
                })
                .orElse(null);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
