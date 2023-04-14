package com.example.Lab4.repositories;

import com.example.Lab4.domain.Exception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExceptionRepository extends JpaRepository<Exception, Long> {

}
