CREATE table checkout (
 id char(36) PRIMARY KEY ,
 item_id char(36) REFERENCES items,
 date_of_isse TIMESTAMP default CURRENT_TIMESTAMP ,
 date_of_return TIMESTAMP
);
