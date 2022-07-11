package com.example.bookservice.entity;

import com.example.dto.BookDto;
import com.example.dto.BookRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
//        dto.add(Link.of("Test link here"));
        return dto;
    }

    public static Book from(BookRequestDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setCategory(dto.getCategory());
        book.setName(dto.getName());
        book.setPrice(dto.getPrice());
        book.setQuantity(dto.getQuantity());
        return book;
    }
}
