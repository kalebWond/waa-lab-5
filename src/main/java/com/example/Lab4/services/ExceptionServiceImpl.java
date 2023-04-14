package com.example.Lab4.services;

import com.example.Lab4.domain.Exception;
import com.example.Lab4.repositories.ExceptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionServiceImpl implements ExceptionService{

    final ExceptionRepository exceptionRepository;

    public ExceptionServiceImpl(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    @Override
    public List<Exception> findAll() {
        return exceptionRepository.findAll();
    }

    @Override
    public Exception getById(long id) {
        return exceptionRepository.findById(id).get();
    }

    @Override
    public void save(Exception p) {
        exceptionRepository.save(p);
    }
}
