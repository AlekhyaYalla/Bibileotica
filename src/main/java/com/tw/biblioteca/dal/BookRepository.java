package com.tw.biblioteca.dal;

import com.tw.biblioteca.dal.tables.RepositoryConstants;
import com.tw.biblioteca.model.Book;
import com.tw.biblioteca.model.Checkout;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.impl.DSL;
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
                .from(RepositoryConstants.BOOK_TABLE)
                .fetchInto(Book.class);
    }

    public Book getBook(String id) {
        Record record =  dsl.select()
                .from(RepositoryConstants.BOOK_TABLE)
                .where(RepositoryConstants.BOOK_ID.eq(id))
                .fetchOne();
        return (record == null) ?  null :  record.into(Book.class);
    }


    public void insertBook(Book book) {
        dsl.insertInto(RepositoryConstants.BOOK_TABLE,
                DSL.field("id"),
                DSL.field("title"),
                DSL.field("author"),
                DSL.field("publish_year"),
                DSL.field("isbn"),
                DSL.field("count"))
                .values(book.getId(),book.getTitle(),book.getAuthor(),book.getPublish_year(),book.getIsbn(),book.getCount())
                .execute();

    }

}
