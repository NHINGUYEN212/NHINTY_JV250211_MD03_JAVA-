CREATE DATABASE session14_2; 
USE session14_2;

-- Tạo bảng products
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY, 
    product_name VARCHAR(100) NOT NULL,        
    category VARCHAR(50) NOT NULL,            
    price DECIMAL(10, 2) NOT NULL,            
    stock_quantity INT NOT NULL               
);

-- Thêm bản ghi vào products
INSERT INTO products (product_name, category, price, stock_quantity)
VALUES
('Laptop Dell XPS 13', 'Electronics', 25999.99, 10),
('Nike Air Max 270', 'Footwear', 4999.00, 50),
('Samsung Galaxy S22', 'Electronics', 19999.99, 25),
('T-Shirt Uniqlo', 'Clothing', 299.99, 100),
('Apple AirPods Pro', 'Accessories', 5999.00, 15),
('T-Shirt Apolo', 'Clothing', 199.99, 100);

-- Viết câu lệnh truy vấn để lấy thông tin các sản phẩm từ bảng dữ liệu bao gồm các trường:
select p.product_id , p.product_name , p.price , (p.price * 1.1 ) as new_price 
from products p ;

-- Viết câu lệnh truy vấn để lọc các sản phẩm có giá dưới 10,000 và có số lượng tồn kho 
select p.product_id , p.product_name , p.price , p.stock_quantity 
from products p 
where p.price < 10000 and p.stock_quantity > 20 ;
    
-- Viết câu lệnh truy vấn để tính tổng số tiền tồn kho của sản phẩm. 
select p.product_id, p.product_name, p.price, p.stock_quantity , (p.price * p.stock_quantity) as  total_stock_value 
from products p;
    
-- Viết câu lệnh truy vấn để lọc các sản phẩm thuộc danh mục Electronics hoặc có giá trên 20,000. 
select product_id, product_name, category, price 
from products 
where category = 'Electronics' or price > 20000 ;