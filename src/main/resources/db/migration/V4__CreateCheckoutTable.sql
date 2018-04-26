CREATE table checkout (
 id char(36) PRIMARY KEY ,
 book_id char(36) REFERENCES book,
 date_of_isse TIMESTAMP default CURRENT_TIMESTAMP ,
 date_of_return TIMESTAMP
);

