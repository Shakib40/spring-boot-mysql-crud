package com.crud.service;

import com.crud.dto.*;
import com.crud.entity.Book;
import com.crud.exception.ResourceNotFoundException;
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
    public CreateBookDto createBook(CreateBookDto createBookDto) {
        Book book = new Book();
        book.setTitle(createBookDto.getTitle());
        book.setAuthor(createBookDto.getAuthor());
        book.setPrice(createBookDto.getPrice());
        book.setPublishDate(createBookDto.getPublishDate());

        Book savedBook = bookRepository.save(book);
        return new CreateBookDto(savedBook);
    }

    @Override
    public List<ListBookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(ListBookDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public CreateBookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        return new CreateBookDto(book);
    }

    @Override
    public CreateBookDto updateBook(Long id, CreateBookDto bookDto) {
        Book existing = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        existing.setTitle(bookDto.getTitle());
        existing.setAuthor(bookDto.getAuthor());
        existing.setPrice(bookDto.getPrice());
        existing.setPublishDate(bookDto.getPublishDate());

        Book updated = bookRepository.save(existing);
        return new CreateBookDto(updated);
    }

    @Override
    public void deleteBook(Long id) {
        Book existing = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        bookRepository.delete(existing);
    }
}
