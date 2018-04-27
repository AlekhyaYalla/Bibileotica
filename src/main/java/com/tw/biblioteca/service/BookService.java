package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import com.tw.biblioteca.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookForCheckout(String id){
        return bookRepository.getBook(id);
    }
}
