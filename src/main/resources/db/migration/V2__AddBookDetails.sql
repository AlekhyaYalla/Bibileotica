ALTER TABLE book ADD author VARCHAR(100);
ALTER TABLE book ADD publish_year VARCHAR(50);
ALTER TABLE book ADD isbn VARCHAR(100);

UPDATE book
  SET author = 'J. K. Rowling',
      publish_year = '2001',
      isbn = '978-3-16-148410-0'
  WHERE id = 'bb484940-3e2c-11e8-b566-0800200c9a66';

UPDATE book
  SET author = 'J. K. Rowling',
      publish_year = '2004',
      isbn = '978-3-16-148410-1'
  WHERE id = '20b5dcc0-3e2d-11e8-b566-0800200c9a66';

UPDATE book
  SET author = 'J. K. Rowling',
      publish_year = '2005',
      isbn = '978-3-16-148410-2'
  WHERE id = '347874c0-3e2d-11e8-b566-0800200c9a66';


UPDATE book
  SET author = 'J. K. Rowling',
      publish_year = '2002',
      isbn = '978-3-16-148410-3'
  WHERE id = 'cd81aa07-4682-47c7-bc9e-7fe0c3217697';


