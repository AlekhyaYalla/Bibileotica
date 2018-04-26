package com.tw.biblioteca.exception;

import java.util.Objects;
import java.util.UUID;

public class ApplicationError {

    private String id;
    private int status;
    private String code;


    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {

        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public ApplicationError(int status, String code) {

        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationError that = (ApplicationError) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, status, code);
    }
}
