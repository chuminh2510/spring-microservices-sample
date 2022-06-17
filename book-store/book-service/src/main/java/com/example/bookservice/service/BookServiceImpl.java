package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepo;

    @Override
    public Book save(Book data) {
        return bookRepo.save(data);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book update(Book data) {
        return bookRepo.save(data);
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
