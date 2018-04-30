create table items (
 id char(36) PRIMARY KEY ,
 title varchar (200),
 release_year integer,
 count integer,
 type varchar(50),
 details CLOB
);


INSERT  INTO items values('bb484940-3e2c-11e8-b566-0800200c9a66','Harry Potter - The Philosphers stone',2001,3,'book','978-3-16-148410-0,J. K. Rowling');
INSERT  INTO items values('20b5dcc0-3e2d-11e8-b566-0800200c9a66','Harry Potter - Prisoner of Azkaban',2004,4,'book','978-3-16-148410-1,J. K. Rowling');
INSERT  INTO items values('347874c0-3e2d-11e8-b566-0800200c9a66','Harry Potter - The goblet of fire',2005,3,'book','978-3-16-148410-2,J. K. Rowling');
INSERT  INTO items values('cd81aa07-4682-47c7-bc9e-7fe0c3217697','Harry Potter - The Chamber of Secrets',2002,5,'book','978-3-16-148410-3,J. K. Rowling');
INSERT  INTO items values('958cc434-1ff0-4228-8118-a56dcb82d6d2','Batman Begins',2005,3,'movie','Christopher Nolan,IMDb:8.3');
INSERT  INTO items values('7636daf9-682a-4f33-b985-395c360ed4a5','Interstellar',2014,5,'movie','Christopher Nolan,IMDb:8.6');
INSERT  INTO items values('785e52de-3152-4f19-a06c-d663ccd3da04','Baahubali: The Beginning',2015,4,'movie','S. S. Rajamouli,IMDb:8.2');