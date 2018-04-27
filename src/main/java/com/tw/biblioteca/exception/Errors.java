package com.tw.biblioteca.exception;

import java.util.Arrays;
import java.util.List;

public class Errors {


    public List<ApplicationError> errors;


    public List<ApplicationError> getErrors() {
        return errors;
    }

    public Errors(List<ApplicationError> errors) {
        this.errors = errors;
    }


    public static Errors endPointNotFound() {
        ApplicationError applicationError = new ApplicationError(ExceptionConstants.STATUS_404, ExceptionConstants.STATUS_404_CODE);
        return new Errors(Arrays.asList(applicationError));
    }
}
