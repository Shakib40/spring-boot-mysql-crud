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

    private BookDto convertToDto(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        return dto;
    }

    private Book convertToEntity(BookDto dto) {
        Book book = new Book();
        book.setId(dto.getId()); // Optional for create
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return book;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = convertToEntity(bookDto);
        return convertToDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book != null ? convertToDto(book) : null;
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book existing = bookRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(bookDto.getTitle());
        existing.setAuthor(bookDto.getAuthor());
        existing.setPrice(bookDto.getPrice());

        return convertToDto(bookRepository.save(existing));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
