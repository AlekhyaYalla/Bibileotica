package com.tw.biblioteca.dal;

import com.tw.biblioteca.dal.tables.BookConstants;
import com.tw.biblioteca.model.Book;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class BookRepository {

    private final DSLContext dsl;

    @Autowired
    public BookRepository(DSLContext dsl) {
        this.dsl = dsl;
    }


    public List<Book> getAllBooks() {
        return dsl.select()
                .from(BookConstants.BOOK_TABLE)
                .fetchInto(Book.class);
    }
}
