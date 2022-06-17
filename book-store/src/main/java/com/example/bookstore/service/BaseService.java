package com.example.bookstore.service;

import java.util.List;

public interface BaseService<T, K> {
    T save(T data);

    List<T> findAll();

    T update(T data);

    int delete(T data);

    T findById(K id);


}
