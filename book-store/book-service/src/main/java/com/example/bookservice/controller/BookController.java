package com.example.bookservice.controller;

import com.example.bookstore.dto.BookDto;
import com.example.bookservice.entity.Book;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @PostMapping(value = "")
    public BookDto insert(Book data) {
        return bookService.save(data).toDto();
    }

    @PutMapping(value = "")
    public BookDto update(Book data) {
        return bookService.update(data).toDto();
    }

    @GetMapping(value = "")
    public List<BookDto> findAll() {
        return bookService.findAll().stream().map(Book::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public BookDto detailBook(@PathVariable Integer id) {
        return bookService.findById(id).toDto();
    }

    @DeleteMapping(value = "/{id}")
    public int delete(@PathVariable Integer id) {
        Book book = new Book();
        book.setId(id);
        return bookService.delete(book);
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
