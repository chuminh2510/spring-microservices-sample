package com.example.userservice.feignclient;

import com.example.bookstore.dto.BookDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class BookFeignFallbackClient implements BookFeignClient {

    @Override
    public List<BookDto> findAll() {
        log.error("Response from Fallback client");
        return new ArrayList<>();
    }

    @Override
    public BookDto detailBook(Integer id) {
        log.error("Response from Fallback client");
        return new BookDto();
    }
}
