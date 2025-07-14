delete from readers
where readerId = 7 and not exists(
select * from borrows where readerId = 7);

delete from books
where bookId = 1 and not exists(
select * from borrows where bookId = 1);

delete from borrows
where bookId = 1;

delete from books
where bookId =1;