package com.tw.biblioteca.dal.tables;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

public class RepositoryConstants {
    public static final Table ITEM_TABLE = DSL.table("items");
    public static final Field ITEM_ID = DSL.field("id");
    public static final Field ITEM_TITLE = DSL.field("title");
    public static final Field ITEM_RELEASE_YEAR = DSL.field("release_year");
    public static final Field ITEM_COUNT = DSL.field( "count");
    public static final Field ITEM_TYPE = DSL.field("type");


    public static final Table CHECKOUT_TABLE = DSL.table("checkout");
    public static final Field CHECKOUT_ID = DSL.field("id");
    public static final Field CHECKOUT_ITEM_ID = DSL.field("item_id");
    public static final Field CHECKOUT_DATE_OF_ISSE = DSL.field("date_of_issue");
    public static final Field CHECKOUT_DATE_OF_RETURN = DSL.field("date_of_return");

}
