package com.tw.biblioteca.controller;

import com.tw.biblioteca.exception.ItemNotAvailableException;
import com.tw.biblioteca.exception.ItemNotFoundException;
import com.tw.biblioteca.model.Checkout;
import com.tw.biblioteca.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckoutController {
    private CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @RequestMapping(value = "item/{itemId}/checkout", method = RequestMethod.POST)
    public String insertCheckoutRecord(@PathVariable String itemId) throws ItemNotAvailableException, ItemNotFoundException {
        checkoutService.insertCheckoutRecord(itemId);
        return "Your Checkout Successful :)";
    }

    @RequestMapping(value = "/allCheckouts", method = RequestMethod.GET)
    public List<Checkout> getAllCheckouts() {
        return checkoutService.getAllCheckouts();
    }

    /*@RequestMapping(value = "book/{bookId}/return/{checkoutId}/", method = RequestMethod.POST)
    public String returnCheckoutBook(@PathVariable String checkoutId,@PathVariable String bookId) throws Exception {
        checkoutService.returnCheckoutBook(checkoutId,bookId);
        return "You returned your book successfully";
    }*/
}
