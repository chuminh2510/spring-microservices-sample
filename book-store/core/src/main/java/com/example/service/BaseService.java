package com.example.service;

import java.util.List;

public interface BaseService<T, K, V> {
    T save(V data);

    List<T> findAll();

    T update(V data);

    int delete(T data);

    T findById(K id);


}
