package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import com.tw.biblioteca.dal.CheckoutRepository;
import com.tw.biblioteca.exception.BookNotAvailableException;
import com.tw.biblioteca.exception.BookNotFoundException;
import com.tw.biblioteca.model.Book;
import com.tw.biblioteca.model.Checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private CheckoutRepository checkoutRepository;
    private BookRepository bookRepository;

    @Autowired
    public CheckoutService(CheckoutRepository checkoutRepository, BookRepository bookRepository) {
        this.checkoutRepository = checkoutRepository;
        this.bookRepository = bookRepository;
    }

    public void insertCheckoutRecord(String id) throws BookNotFoundException, BookNotAvailableException {
        Book book = bookRepository.getBook(id);
        if (book == null)
            throw new BookNotFoundException("Book not Found in the Library");
        if (!isBookInStock(book))
            throw new BookNotAvailableException("Book not available for check out");
        Checkout checkout = new Checkout(book);
        checkoutRepository.insertCheckoutRecord(checkout);
    }

    private Boolean isBookInStock(Book book) {
        return book.getCount() - checkoutRepository.getBookRecordCount(book.getId()) > 0;
    }


}
