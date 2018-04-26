ALTER TABLE book ADD count INTEGER ;

UPDATE book
  SET count = 5
  WHERE id = 'bb484940-3e2c-11e8-b566-0800200c9a66';

UPDATE book
  SET count = 4
  WHERE id = '20b5dcc0-3e2d-11e8-b566-0800200c9a66';

UPDATE book
  SET count = 4
  WHERE id = '347874c0-3e2d-11e8-b566-0800200c9a66';

UPDATE book
  SET count = 6
  WHERE id = 'cd81aa07-4682-47c7-bc9e-7fe0c3217697';
