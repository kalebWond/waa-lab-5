package com.example.Lab4.repositories;

import com.example.Lab4.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {

}
