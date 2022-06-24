package com.example.bookstore.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class BookDto extends RepresentationModel<BookDto> {
    private Integer id;
    private String name;
    private Integer quantity;
    private String category;

}
