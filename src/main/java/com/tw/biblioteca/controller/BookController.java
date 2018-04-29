package com.tw.biblioteca.controller;

import com.tw.biblioteca.exception.Errors;
import com.tw.biblioteca.model.Book;
import com.tw.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @ResponseBody
    @RequestMapping(value = "/book/insert", method = RequestMethod.POST)
    public void insertBooks(@RequestBody String rawBooksData) {
        bookService.insertBooks(rawBooksData);
    }
}
