package com.example.bookservice.entity;

import com.example.bookstore.dto.BookDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    private Integer id;
    private String name;
    private String category;

    private Integer quantity;

    private Integer price;

    public BookDto toDto() {
        BookDto dto = new BookDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setCategory(this.category);
        dto.add(Link.of("Test link here"));
        return dto;
    }
}
