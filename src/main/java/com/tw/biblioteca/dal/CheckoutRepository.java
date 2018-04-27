package com.tw.biblioteca.dal;

import com.tw.biblioteca.dal.tables.RepositoryConstants;
import com.tw.biblioteca.model.Checkout;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CheckoutRepository {

    private final DSLContext dsl;

    @Autowired
    public CheckoutRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void insertCheckoutRecord(Checkout checkout) {
        dsl.insertInto(RepositoryConstants.CHECKOUT_TABLE,
                DSL.field("id"),
                DSL.field("book_id"))
                .values(checkout.getId(), checkout.getBook_id())
                .execute();

    }

    public List<Checkout> getAllCheckouts() {
        return dsl.select()
                .from(RepositoryConstants.CHECKOUT_TABLE)
                .fetchInto(Checkout.class);
    }

    public Integer getBookRecordCount(String bookId) {
        return dsl.select()
                .from(RepositoryConstants.CHECKOUT_TABLE)
                .where(RepositoryConstants.CHECKOUT_BOOK_ID.eq(bookId))
                .fetchInto(Checkout.class).size();
    }
}
