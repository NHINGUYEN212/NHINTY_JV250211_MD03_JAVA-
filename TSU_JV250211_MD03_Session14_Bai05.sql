CREATE DATABASE session14_5;
USE session14_5;

-- Tạo bảng Products
CREATE TABLE Products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,  -- Khóa chính tự động tăng
    ProductName VARCHAR(100) NOT NULL,         -- Tên sản phẩm
    Category VARCHAR(50) NOT NULL,             -- Loại sản phẩm
    Price DECIMAL(10, 2) NOT NULL,             -- Giá sản phẩm
    Stock INT NOT NULL                         -- Số lượng tồn kho
);
-- Thêm dữ liệu vào bảng Products
INSERT INTO Products (ProductName, Category, Price, Stock)
VALUES
    ('iPhone 14', 'Electronics', 1000.00, 50),
    ('MacBook Air', 'Electronics', 1200.00, 30),
    ('T-Shirt', 'Fashion', 20.00, 200),
    ('Sneakers', 'Fashion', 100.00, 100),
    ('Refrigerator', 'Appliances', 800.00, 10),
    ('Air Conditioner', 'Appliances', 600.00, 15),
    ('Laptop', 'Electronics', 1500.00, 25),
    ('Headphones', 'Electronics', 200.00, 75),
    ('Jacket', 'Fashion', 150.00, 50),
    ('Washing Machine', 'Appliances', 700.00, 8);
-- Tìm tên sản phẩm (ProductName), loại sản phẩm (Category), và giá (Price) của các sản phẩm có giá cao hơn sản phẩm "MacBook Air"
select ProductName, Category, Price
from Products 
where  Price >(
        select Price from Products
        where ProductName ='MacBook Air');

-- Tìm tên sản phẩm (ProductName), loại sản phẩm (Category), và giá (Price) của các sản phẩm thuộc loại "Electronics" nhưng có giá thấp hơn sản phẩm "Laptop"
select ProductName, Category, Price
from Products
where Category ='Electronics' and
      Price < (
		select Price
        from Products 
        where ProductName = 'Laptop'
        );
        
-- Tìm tên sản phẩm (ProductName), giá (Price), và số lượng tồn kho (Stock) của các sản phẩm có số lượng tồn kho thấp hơn sản phẩm "T-Shirt"
select ProductName, Price, Stock 
from Products
where Stock < (
       select Stock 
       from Products
       where ProductName = 'T-Shirt'
       );
       
       