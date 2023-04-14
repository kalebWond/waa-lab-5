package com.example.Lab4.aop;

import com.example.Lab4.domain.Logger;
import com.example.Lab4.services.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    final LoggerService loggerService;

    public LoggerAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    // make sure advice doesn't run for the logger service, so as not to create infinite loop
    // used @AfterReturning because @After advice will run also for exceptions
    @AfterReturning("execution(* com.example.Lab4.services.*.*(..)) " +
            "&& !execution(* com.example.Lab4.services.LoggerService.*(..)) " +
            "&& !execution(* com.example.Lab4.services.ExceptionService.*(..))")
    public void traceAfterMethod(JoinPoint joinpoint) {
        String log = "after execution of method "+joinpoint.getSignature().getName()+
                " in "+ joinpoint.getSignature().getDeclaringType().getName();
        Logger logger = new Logger(LocalDate.now(), LocalTime.now(), "Principal User", log);
        loggerService.save(logger);
    }

}