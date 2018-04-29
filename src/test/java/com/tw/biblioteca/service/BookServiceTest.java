package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import com.tw.biblioteca.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void shouldCallInsertBookInService(){
        BookService bookService = new BookService(bookRepository);
        String rawData = "195153448,Classical Mythology,Mark P. O. Morford,2002,Oxford University Press\n" +
                "2005018,Clara Callan,Richard Bruce Wright,2001,HarperFlamingo Canada";
        Book book = new Book("9333f964-0dd3-49d6-8856-2ead194e9eb2",
                "Classical Mythology", "Mark P. O. Morford",
                "2002", "195153448", 1);
        bookService.insertBooks(rawData);

        verify(bookRepository).insertBook(book);


    }


}
