package com.example.userservice.entity;

import com.example.bookstore.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
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
}
