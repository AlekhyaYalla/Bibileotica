package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

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
}
