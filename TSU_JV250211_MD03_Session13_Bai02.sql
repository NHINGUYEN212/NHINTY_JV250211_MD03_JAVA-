CREATE DATABASE library_management;
USE library_management;

CREATE TABLE books (
    bookId INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL UNIQUE,borrowsborrowsbooksborrowsreaders
    author VARCHAR(50) NOT NULL,
    publishedYear YEAR NOT NULL,
    category VARCHAR(50) NOT NULL
);

CREATE TABLE readers (
    readerId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    birthDate DATE NOT NULL ,
    address VARCHAR(255),
    phoneNumber VARCHAR(11)
);

	CREATE TABLE borrows (
		borrowId INT AUTO_INCREMENT PRIMARY KEY,
		borrowDate DATE NOT NULL,
		returnDate DATE,
		bookId INT,
		readerId INT,
		FOREIGN KEY (bookId) REFERENCES books(bookId),
		FOREIGN KEY (readerId) REFERENCES readers(readerId)
	);