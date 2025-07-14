INSERT INTO books (title, author, publishedYear, category) VALUES
('Dế mèn phiêu lưu ký', 'Tô Hoài', 1941, 'Truyện thiếu nhi'),
('Hoàng tử bé', 'Antoine de Saint-Exupéry', 1943, 'Tiểu thuyết'),
('1984', 'George Orwell', 1949, 'Tiểu thuyết phản địa đàng'),
('Bắt trẻ đồng xanh', 'J.D. Salinger', 1951, 'Tiểu thuyết'),
('Trăm năm cô đơn', 'Gabriel García Márquez', 1967, 'Tiểu thuyết'),
('Rừng Na Uy', 'Haruki Murakami', 1987, 'Tiểu thuyết'),
('Đắc nhân tâm', 'Dale Carnegie', 1936, 'Phát triển bản thân'),
('Harry Potter và Hòn đá Phù thủy', 'J.K. Rowling', 1997, 'Tiểu thuyết kỳ ảo'),
('Sapiens: Lược sử loài người', 'Yuval Noah Harari', 2011, 'Khoa học'),
('Cuốn theo chiều gió', 'Margaret Mitchell', 1936, 'Tiểu thuyết');

UPDATE books
SET author = 'Nguyễn Văn A'
WHERE bookId = 1;

SELECT * FROM books
WHERE title LIKE 'A%' OR title LIKE 'B%';
