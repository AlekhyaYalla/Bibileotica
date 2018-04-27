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

    @Test
    public void shouldReturnCheckoutBook() throws Exception {
        CheckoutController checkoutController = new CheckoutController(checkoutService);
        String checkout = "7c8f1879-61ed-4aa5-a903-d27b1faa994b";
        checkoutController.returnCheckoutBook(checkout,"20b5dcc0-3e2d-11e8-b566-0800200c9a66");
        verify(checkoutService).returnCheckoutBook(checkout,"20b5dcc0-3e2d-11e8-b566-0800200c9a66");


    }

}
