package com.tw.biblioteca.dal;

import com.tw.biblioteca.dal.tables.RepositoryConstants;
import com.tw.biblioteca.model.Book;
import com.tw.biblioteca.model.Item;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ItemRepository {

    private final DSLContext dsl;

    @Autowired
    public ItemRepository(DSLContext dsl) {
        this.dsl = dsl;
    }


    public List<Item> getAllItems() {
        return dsl.select()
                .from(RepositoryConstants.ITEM_TABLE)
                .fetchInto(Item.class);
    }

    public Item getItem(String id) {
        Record record =  dsl.select()
                .from(RepositoryConstants.ITEM_TABLE)
                .where(RepositoryConstants.ITEM_ID.eq(id))
                .fetchOne();
        return (record == null) ?  null :  record.into(Item.class);
    }

    public List<Item> getItemsOfType(String itemType) {
        return  dsl.select()
                .from(RepositoryConstants.ITEM_TABLE)
                .where(RepositoryConstants.ITEM_TYPE.eq(itemType))
                .fetchInto(Item.class);
    }



    /*public void insertBook(Book book) {
        dsl.insertInto(RepositoryConstants.ITEM_TABLE,
                DSL.field(RepositoryConstants.ITEM_ID),
                DSL.field(RepositoryConstants.ITEM_TITLE),
                DSL.field(RepositoryConstants.BOOK_AUTHOR),
                DSL.field(RepositoryConstants.ITEM_RELEASE_YEAR),
                DSL.field(RepositoryConstants.BOOK_ISBN),
                DSL.field(RepositoryConstants.ITEM_COUNT))
                .values(book.getId(),book.getTitle(),book.getAuthor(),book.getPublish_year(),book.getIsbn(),book.getCount())
                .execute();

    }

    public Book getBooksForIsbn(String isbn) {
        Record record =  dsl.select()
                .from(RepositoryConstants.ITEM_TABLE)
                .where(RepositoryConstants.BOOK_ISBN.eq(isbn))
                .fetchOne();
        return (record == null) ?  null :  record.into(Book.class);

    }*/
}
