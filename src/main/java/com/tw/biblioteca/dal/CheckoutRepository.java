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

import java.sql.Timestamp;
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
                RepositoryConstants.CHECKOUT_ID,
                RepositoryConstants.CHECKOUT_ITEM_ID)
                .values(checkout.getId(), checkout.getItem_id())
                .execute();

    }

    public List<Checkout> getAllCheckouts() {
        return dsl.select()
                .from(RepositoryConstants.CHECKOUT_TABLE)
                .fetchInto(Checkout.class);
    }

    public Integer getItemRecordsCount(String itemId) {
        return dsl.select()
                .from(RepositoryConstants.CHECKOUT_TABLE)
                .where(RepositoryConstants.CHECKOUT_ITEM_ID.eq(itemId))
                .and(RepositoryConstants.CHECKOUT_DATE_OF_RETURN.isNull())
                .fetchInto(Checkout.class).size();
    }



    public void updateDateOfReturnInCheckout(String checkoutId) {
        dsl.update(RepositoryConstants.CHECKOUT_TABLE)
                .set(RepositoryConstants.CHECKOUT_DATE_OF_RETURN,new Timestamp(System.currentTimeMillis()))
                .where(RepositoryConstants.CHECKOUT_ID.eq(checkoutId))
                .execute();
    }

    public Checkout getCheckoutRecord(String checkoutId) {
        Record record =  dsl.select()
                .from(RepositoryConstants.CHECKOUT_TABLE)
                .where(RepositoryConstants.CHECKOUT_ID.eq(checkoutId))
                .fetchOne();
        return (record == null) ?  null :  record.into(Checkout.class);
    }

}
