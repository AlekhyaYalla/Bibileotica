package com.tw.biblioteca.exception;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ErrorsTest {


    @Test
    public void shouldReturnEndpointNotFoundErrorObject() {
        ApplicationError applicationError = new ApplicationError(ExceptionConstants.STATUS_404, ExceptionConstants.STATUS_404_CODE);
        assertArrayEquals(Errors.endPointNotFound().errors.toArray(),Arrays.asList(applicationError).toArray());
    }
}
