package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.service.BaseService;

public interface BookService extends BaseService<Book, Integer, BookRequestDto> {
}
