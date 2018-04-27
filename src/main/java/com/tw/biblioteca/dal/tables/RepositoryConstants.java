package com.tw.biblioteca.dal.tables;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

public class RepositoryConstants {
    public static final Table BOOK_TABLE = DSL.table("book");
    public static final Field BOOK_ID = DSL.field("id");
    public static final Field CHECKOUT_BOOK_ID = DSL.field("book_id");
    public static final Table CHECKOUT_TABLE = DSL.table("checkout");

}
