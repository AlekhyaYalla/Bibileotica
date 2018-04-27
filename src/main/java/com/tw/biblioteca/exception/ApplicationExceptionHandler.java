package com.tw.biblioteca.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Errors> handleBookNotFoundException(HttpServletRequest httpServletRequest, Exception ex) {
        ApplicationError appError = new ApplicationError(
                ExceptionConstants.STATUS_414,
                ExceptionConstants.STATUS_414_CODE);
        Errors errors = new Errors(Arrays.asList(appError));
        return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BookNotAvailableException.class})
    public ResponseEntity<Errors> handleBookNotAvailableException(HttpServletRequest httpServletRequest, Exception ex) {
        ApplicationError appError = new ApplicationError(
                ExceptionConstants.STATUS_422,
                ExceptionConstants.STATUS_422_CODE);
        Errors errors = new Errors(Arrays.asList(appError));
        return new ResponseEntity<>(errors,HttpStatus.UNPROCESSABLE_ENTITY);
    }


}

