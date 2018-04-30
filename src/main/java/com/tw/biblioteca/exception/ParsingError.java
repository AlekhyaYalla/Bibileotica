package com.tw.biblioteca.exception;

public class ParsingError {
    private String id;
    private int lineNumber;
    private String code;

    public ParsingError(String id, int lineNumber, String code) {
        this.id = id;
        this.lineNumber = lineNumber;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getCode() {
        return code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
