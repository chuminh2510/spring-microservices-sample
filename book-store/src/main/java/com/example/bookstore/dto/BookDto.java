package com.example.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto extends BaseDto {
    private Integer id;
    private String name;
    private Integer quantity;
    private String category;

}
