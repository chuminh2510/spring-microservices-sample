package com.example.userservice.controller;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.UserDto;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    @PostMapping(value = "")
    public UserDto insert(User data) {
        return userService.save(data).toDto();
    }

    @PutMapping(value = "")
    public UserDto update(User data) {
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


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
