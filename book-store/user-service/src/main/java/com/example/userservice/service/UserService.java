package com.example.userservice.service;

import com.example.dto.UserRequestDto;
import com.example.service.BaseService;
import com.example.userservice.entity.User;

public interface UserService extends BaseService<User, Integer, UserRequestDto> {
}
