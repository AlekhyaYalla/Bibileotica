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

import static org.assertj.core.api.Assertions.assertThat;
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
        checkoutService.insertCheckoutRecord("b79f228c");

        verify(checkoutRepository).insertCheckoutRecord(checkOutArgumentCaptor.capture());
        assertThat(checkout.getBook_id()).isEqualTo("3245dfe6-b382-400a-a255-5dc7ba98987b");
    }

    @Test
    public void shouldReturnTrueForIsBookInStock() {
        Book book = new Book("3245dfe6-b382-400a-a255-5dc7ba98987b",
                "Socerers stone", "J K Rowling",
                "2000", "978-3-16-148410-0", 2);
        verify(checkoutRepository).getBookRecordCount(book.getId());


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
        when(checkoutRepository.getBookRecordCount(book.getId())).thenReturn(3);
        checkoutService.insertCheckoutRecord("1234");
    }


}