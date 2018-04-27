package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import com.tw.biblioteca.dal.CheckoutRepository;
import com.tw.biblioteca.exception.BookAlreadyReturned;
import com.tw.biblioteca.exception.BookNotAvailableException;
import com.tw.biblioteca.exception.BookNotFoundException;
import com.tw.biblioteca.exception.NoCheckOutAvailable;
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
        return book.getCount() - checkoutRepository.getBookRecordsCount(book.getId()) > 0;
    }


    public void returnCheckoutBook(String checkoutId,String bookId) throws Exception {
        Checkout checkoutRecord = checkoutRepository.getCheckoutRecord(checkoutId);
        if (checkoutRecord == null)
            throw new NoCheckOutAvailable("No Checkout record found");
        if( !isBookValidAndReturnAvailableForCheckout(checkoutRecord, bookId))
            throw new BookAlreadyReturned("Book Already returned");
        checkoutRepository.updateDateOfReturnInCheckout(checkoutId);
    }


    public Boolean isBookValidAndReturnAvailableForCheckout(Checkout checkoutRecord, String bookId) {
        return checkoutRecord.getDate_of_return() == null && checkoutRecord.getBook_id().equals(bookId);
    }
}
