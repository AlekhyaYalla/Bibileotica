package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import com.tw.biblioteca.dal.CheckoutRepository;
import com.tw.biblioteca.exception.BookNotAvailableException;
import com.tw.biblioteca.exception.BookNotFoundException;
import com.tw.biblioteca.model.Book;
import com.tw.biblioteca.model.Checkout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {

    @Mock
    private CheckoutRepository checkoutRepository;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookService bookService;
    @Captor
    private ArgumentCaptor<Checkout> checkOutArgumentCaptor;


    @Test
    public void shouldCheckOutBook() throws BookNotFoundException, BookNotAvailableException {
        Book book = new Book("3245dfe6-b382-400a-a255-5dc7ba98987b",
                "Socerers stone", "J K Rowling",
                "2000", "978-3-16-148410-0", 2);
        when(bookRepository.getBook(book.getId())).thenReturn(book);

        Checkout checkout = new Checkout(book);
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        checkoutService.insertCheckoutRecord(book.getId());

        verify(checkoutRepository).insertCheckoutRecord(checkOutArgumentCaptor.capture());
        assertThat(checkout.getBook_id()).isEqualTo("3245dfe6-b382-400a-a255-5dc7ba98987b");
    }

    @Test
    public void shouldReturnTrueForIsBookInStock() {
        Book book = new Book("3245dfe6-b382-400a-a255-5dc7ba98987b",
                "Socerers stone", "J K Rowling",
                "2000", "978-3-16-148410-0", 2);
        verify(checkoutRepository).getBookRecordsCount(book.getId());


    }

    @Test(expected = BookNotFoundException.class)
    public void shouldThrowExceptionIfBookIdIsInvalid() throws BookNotFoundException, BookNotAvailableException {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        checkoutService.insertCheckoutRecord("1234");
    }

    @Test(expected = BookNotAvailableException.class)
    public void shouldThrowExceptionWhenBookIsNotAvailable() throws BookNotFoundException, BookNotAvailableException {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        Book book = new Book("1234", "title", "author", "123", "isbn", 3);
        when(bookRepository.getBook(any())).thenReturn(book);
        when(checkoutRepository.getBookRecordsCount(book.getId())).thenReturn(3);
        checkoutService.insertCheckoutRecord("1234");
    }

    @Test
    public void shouldReturnCheckoutBook() throws Exception {
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        String checkout = "7c8f1879-61ed-4aa5-a903-d27b1faa994b";
        checkoutService.returnCheckoutBook(checkout,"20b5dcc0-3e2d-11e8-b566-0800200c9a66");
        verify(checkoutRepository).updateDateOfReturnInCheckout(checkout);
    }


    @Test
    public void shouldReturnFalseForIsReturnAvailableForCheckout(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        Checkout checkout = new Checkout("7c8f1879-61ed-4aa5-a903-d27b1faa994b","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        assertFalse(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, checkout.getBook_id()));

    }

    @Test
    public void shouldReturnTrueForDateOfReturnNull(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        Checkout checkout = new Checkout("b4f8f773-8aaa-43d6-bcb3-16f0ddd2d8f3","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),null);
        assertTrue(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, checkout.getBook_id()));

    }

    @Test
    public void shouldReturnFalseForInvalidBook(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        Checkout checkout = new Checkout("7c8f1879-61ed-4aa5-a903-d27b1faa994b","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        assertFalse(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, "12345"));

    }

    @Test
    public void shouldReturnTrueForValidBookAndDateOfReturnNull(){
        CheckoutService checkoutService = new CheckoutService(checkoutRepository, bookRepository);
        Checkout checkout = new Checkout("7c8f1879-61ed-4aa5-a903-d27b1faa994b","20b5dcc0-3e2d-11e8-b566-0800200c9a66",
                new Timestamp(System.currentTimeMillis()),null);
        assertTrue(checkoutService.isBookValidAndReturnAvailableForCheckout(checkout, checkout.getBook_id()));

    }

}