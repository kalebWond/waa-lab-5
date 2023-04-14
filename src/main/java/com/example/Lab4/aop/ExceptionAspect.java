package com.example.Lab4.aop;

import com.example.Lab4.domain.Exception;
import com.example.Lab4.services.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionAspect {
    final ExceptionService exceptionService;

    public ExceptionAspect(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    // test by running "get User by Id" without user
    @AfterThrowing(pointcut = "execution(* com.example.Lab4.services.*.*(..))", throwing = "exception")
    public void traceAfterMethod(JoinPoint joinpoint, RuntimeException exception) {
        String log = "after execution of method "+joinpoint.getSignature().getName()+
                " in "+ joinpoint.getSignature().getDeclaringType().getName();
        String expMessage = exception.getMessage();
        Exception exp = new Exception(LocalDate.now(), LocalTime.now(), "Principal User", log, expMessage);
        exceptionService.save(exp);
    }

}