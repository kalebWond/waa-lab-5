package com.example.Lab4.services;

import com.example.Lab4.domain.Exception;

import java.util.List;

public interface ExceptionService {
    public List<Exception> findAll();

    Exception getById(long id);

    void save(Exception p);
}
