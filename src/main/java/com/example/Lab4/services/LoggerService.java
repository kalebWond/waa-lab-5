package com.example.Lab4.services;

import com.example.Lab4.domain.Logger;

import java.util.List;

public interface LoggerService {
    public List<Logger> findAll();

    Logger getById(long id);

    void save(Logger p);
}
