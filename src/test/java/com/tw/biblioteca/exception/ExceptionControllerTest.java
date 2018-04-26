package com.tw.biblioteca.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionControllerTest {


    @Test
    public void shouldReturnEndPointNotFoundError() {
        ApplicationError errors = new ApplicationError(ExceptionConstants.STATUS_404, ExceptionConstants.STATUS_404_CODE);
        assertArrayEquals(Errors.endPointNotFound().errors.toArray(), Arrays.asList(errors).toArray());
    }
}
