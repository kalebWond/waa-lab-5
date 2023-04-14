package com.example.Lab4.services;

import com.example.Lab4.domain.Logger;
import com.example.Lab4.repositories.LoggerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService{

    final LoggerRepository loggerRepository;

    public LoggerServiceImpl(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Override
    public List<Logger> findAll() {
        return loggerRepository.findAll();
    }

    @Override
    public Logger getById(long id) {
        return loggerRepository.findById(id).get();
    }

    @Override
    public void save(Logger p) {
        loggerRepository.save(p);
    }
}
