package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import com.tw.biblioteca.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Test
    public void shouldCallGetAllBooksInBookRepo(){
        BookService bookService = new BookService(bookRepository);

        bookService.getAllBooks();

        verify(bookRepository).getAllBooks();
    }

    @Test
    public void shouldGetCheckoutBook(){
        BookService bookService = new BookService(bookRepository);

        bookService.getBookForCheckout("test");

        verify(bookRepository).getBook("test");
    }


}
