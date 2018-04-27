package com.tw.biblioteca.controller;

import com.tw.biblioteca.exception.BookNotAvailableException;
import com.tw.biblioteca.exception.BookNotFoundException;
import com.tw.biblioteca.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {
    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @RequestMapping(value = "book/{bookId}/checkout", method = RequestMethod.POST)
    public void insertCheckoutRecord(@PathVariable String bookId) throws BookNotFoundException, BookNotAvailableException {
        checkoutService.insertCheckoutRecord(bookId);
    }
}
