package com.example.userservice.feignclient;

import com.example.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "book-service", fallback = BookFeignFallbackClient.class)
public interface BookFeignClient {

    //    @Retry(name = "myRetry")
    @GetMapping("/books")
    List<BookDto> findAll();

    @GetMapping("/books/{id}")
    BookDto detailBook(@PathVariable Integer id);
}
