package com.example.userservice.entity;

import com.example.dto.UserDto;
import com.example.dto.UserRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setAge(this.age);
        return dto;
    }

    public static User from(UserRequestDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());
        return user;
    }
}
