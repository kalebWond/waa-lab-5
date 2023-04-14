package com.example.Lab4.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDate date;
    LocalTime time;
    String principle;
    String operation;

    public Logger(LocalDate date, LocalTime time, String principle, String operation) {
        this.date = date;
        this.time = time;
        this.principle = principle;
        this.operation = operation;
    }
}
