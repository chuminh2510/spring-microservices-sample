package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.repository.BookRepository;
import com.example.bookstore.dto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepo;

    @Override
    public Book save(BookRequestDto data) {
        Book book = Book.from(data);
        return bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book update(BookRequestDto data) {
        Book book = Book.from(data);
        return bookRepo.save(book);
    }

    @Override
    public int delete(Book data) {
        bookRepo.delete(data);
        return 0;
    }

    @Override
    public Book findById(Integer id) {
        return bookRepo.findById(id).get();
    }

    @Autowired
    public void setBookRepo(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
}
