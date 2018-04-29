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

    @Test
    public void shouldCallInsetBookInService(){
        BookController bookController = new BookController(bookService);
        String rawData = "195153448,Classical Mythology,Mark P. O. Morford,2002,Oxford University Press\n" +
                "2005018,Clara Callan,Richard Bruce Wright,2001,HarperFlamingo Canada";
        bookController.insertBooks(rawData);

        verify(bookService).insertBooks(rawData);
    }


}
