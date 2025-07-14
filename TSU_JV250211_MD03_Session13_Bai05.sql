insert into borrows (borrowDate, returnDate, bookId, readerId) values
('2024-01-10', '2024-01-20', 1, 1),
('2024-02-15', NULL, 3, 2),
('2024-03-05', '2024-03-15', 2, 3),
('2024-04-20', NULL, 5, 4),
('2024-05-01', '2024-05-10', 4, 5),
('2024-05-12', NULL, 7, 6),
('2024-06-01', NULL, 8, 7),
('2024-06-05', '2024-06-20', 6, 8),
('2024-06-10', NULL, 10, 9),
('2024-07-01', '2024-07-10', 9, 10);

update borrows
set returnDate = curdate()
where borrowId = 2;

select *
from borrows
where bookId = 2 and returnDate is not null;