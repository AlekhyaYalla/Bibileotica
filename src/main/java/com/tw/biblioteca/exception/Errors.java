package com.tw.biblioteca.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Errors {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Errors errors1 = (Errors) o;
        return Objects.equals(errors, errors1.errors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(errors);
    }

    public List<ApplicationError> errors;

    public Errors() {
        this.errors = new ArrayList<>();
    }


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
