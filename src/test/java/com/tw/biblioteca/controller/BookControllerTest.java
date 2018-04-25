package com.tw.biblioteca.controller;

import com.tw.biblioteca.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    @Mock
    private BookService bookService;

    @Test
    public void shouldCallGetAllBooksInBookService() {
        BookController bookController = new BookController(bookService);

        bookController.getAllBooks();

        verify(bookService).getAllBooks();
    }

}
