package com.jpa.exercise.service;

import com.jpa.exercise.domain.Author;
import com.jpa.exercise.domain.Book;
import com.jpa.exercise.domain.dto.BookResponse;
import com.jpa.exercise.repository.AuthorRepository;
import com.jpa.exercise.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        // BookResponse에 book만 넘길 수 있게 함 왜냐면 book에 author이 있어서
        List<BookResponse> bookResponses = books.stream()
                .map(book -> BookResponse.of(book)).collect(Collectors.toList());
        return bookResponses;
    }
}
