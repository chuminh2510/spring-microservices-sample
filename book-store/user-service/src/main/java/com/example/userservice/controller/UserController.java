package com.example.userservice.controller;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.UserDto;
import com.example.bookstore.dto.UserRequestDto;
import com.example.userservice.entity.User;
import com.example.userservice.feignclient.BookFeignClient;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private BookFeignClient bookFeignClient;


    @PostMapping(value = "")
    public UserDto insert(@RequestBody UserRequestDto data) {
        log.info("insert");
        return userService.save(data).toDto();
    }

    @PutMapping(value = "")
    public UserDto update(@RequestBody UserRequestDto data) {
        return userService.update(data).toDto();
    }

    @GetMapping(value = "")
    public List<UserDto> findAll() {
        return userService.findAll().stream().map(User::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public UserDto detailUser(@PathVariable Integer id) {
        return userService.findById(id).toDto();
    }

    @DeleteMapping(value = "/{id}")
    public int delete(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        return userService.delete(user);
    }

    @GetMapping("/books")
    public List<BookDto> findAllBooks() {
        return bookFeignClient.findAll();
    }

    @GetMapping("/books/{id}")
    public BookDto detailBooks(@PathVariable Integer id) {
        return bookFeignClient.detailBook(id);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("book-serviceFeignClient")
    public void setBookFeignClient(BookFeignClient bookFeignClient) {
        this.bookFeignClient = bookFeignClient;
    }
}
