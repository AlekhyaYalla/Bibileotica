package com.tw.biblioteca.dal.tables;

import org.jooq.Table;
import org.jooq.impl.DSL;

public class BookConstants {
    public static final Table BOOK_TABLE = DSL.table("book");
}
