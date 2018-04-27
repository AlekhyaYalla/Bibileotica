package com.tw.biblioteca.controller;

import com.tw.biblioteca.exception.BookNotAvailableException;
import com.tw.biblioteca.exception.BookNotFoundException;
import com.tw.biblioteca.service.CheckoutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutControllerTest {

    @Mock
    private CheckoutService checkoutService;

    @Test
    public void shouldCheckIfInsertionIsCalled() throws BookNotFoundException, BookNotAvailableException {
        String id = "check";
        CheckoutController checkoutController = new CheckoutController(checkoutService);

        checkoutController.insertCheckoutRecord(id);

        verify(checkoutService).insertCheckoutRecord(id);
    }

}
