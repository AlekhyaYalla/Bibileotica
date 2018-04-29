package com.tw.biblioteca.service;

import com.tw.biblioteca.dal.BookRepository;
import com.tw.biblioteca.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public void insertBooks(String rawData) {
        String[] arrayOfEachBook = rawData.split("\\r?\\n");
        for(String eachBook : arrayOfEachBook){
            String[] detailsOfEachBook = eachBook.split("\\s*,\\s*");
            Book book = new Book(UUID.randomUUID().toString(),detailsOfEachBook[1],
                    detailsOfEachBook[2],detailsOfEachBook[3],detailsOfEachBook[0],1);
            bookRepository.insertBook(book);
        }

    }
}
