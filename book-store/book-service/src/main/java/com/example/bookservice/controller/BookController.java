package com.example.bookservice.controller;

import com.example.bookservice.entity.Book;
import com.example.bookservice.service.BookService;
import com.example.dto.BookDto;
import com.example.dto.BookRequestDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @PostMapping(value = "")
    public BookDto insert(@RequestBody BookRequestDto data) {
        log.info("insert");
        return bookService.save(data).toDto();
    }

    @PutMapping(value = "")
    public BookDto update(@RequestBody BookRequestDto data) {
        return bookService.update(data).toDto();
    }

    @SneakyThrows
    @GetMapping(value = "")
    public List<BookDto> findAll() {
        log.info("Find all books");
        // To test RETRY of Open-feign or Resilience4j
//        Thread.sleep(30000);
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
