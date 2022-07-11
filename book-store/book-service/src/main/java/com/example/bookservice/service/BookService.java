package com.example.bookservice.service;

import com.example.bookservice.entity.Book;
import com.example.dto.BookRequestDto;
import com.example.service.BaseService;

public interface BookService extends BaseService<Book, Integer, BookRequestDto> {
}
