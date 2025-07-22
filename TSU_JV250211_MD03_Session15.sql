create database Ecommerce;
use Ecommerce;

create table Users (
    user_id int auto_increment  primary key,
    user_name varchar(30) not null,
    email varchar(50) not null unique,
    password varchar(30) not null,
    user_created_at date
);

create table Categories (
    category_id int auto_increment primary key,
    category_name varchar(100) not null unique,
    category_description text
);

create table Products (
    product_id varchar(20) primary key,
    product_name varchar(50) not null unique,
    product_price float not null check ( product_price > 0 ),
    stock int default 0,
    category_id int,
    foreign key (category_id) references Categories (category_id)
);

create table Orders (
    order_id int auto_increment primary key,
    user_id int,
    foreign key (user_id) references Users (user_id),
    order_created_at date,
    order_total_amount float
);

create table Order_Details (
    order_id int,
    foreign key (order_id) references Orders (order_id),
    product_id varchar(20),
    foreign key (product_id) references Products (product_id),
    primary key (order_id, product_id),
    quantity int not null check ( quantity > 0 ),
    price_at_time float not null
);

-- 2.3 Thêm dữ liệu cho các bảng

insert into Categories (category_name, category_description)
values
    ('Điện tử', 'Thiết bị công nghệ'),
    ('Thời trang', 'Quần áo, phụ kiện'),
    ('Gia dụng', 'Đồ dùng gia đình'),
    ('Thể thao', 'Thiết bị thể thao'),
    ('Sách', 'Sách học, kỹ năng, kỹ thuật');

insert into Users (user_name, email, password)
values
    ('Nguyễn Văn An', 'annv@gmail.com', '123456'),
    ('Trần Thị Bình', 'binhtt@rikkeisoft.com', '123456'),
    ('Lê Văn Chiến', 'chienlv@rikkei.academy.com', '123456'),
    ('Nguyễn Hà Quyên', 'quyennh@rikkei.education.com', '123456'),
    ('Võ Văn Hải', 'haivv@rikkei.education.com', '123456');

insert into Products (product_id, product_name, product_price, stock, category_id)
values
    ('P001', 'Iphone 14', 20000000, 10, 1),
    ('P002', 'Laptop Dell XPS', 30000000, 5, 1),
    ('P003','Áo thun nam', 250000, 50, 2),
    ('P004','Quần jean nữ', 400000, 40, 2),
    ('P005','Nồi cơm điện Sharp', 800000, 20, 3);

insert into Orders (user_id, order_total_amount, order_created_at)
values
    (1, 20200000, '2024-06-01'),
    (2, 325000, '2024-06-01'),
    (3, 800000, '2024-06-02'),
    (4, 1500000, '2024-06-02'),
    (5, 700000, '2024-08-03'),
    (1, 150000, '2024-08-03'),
    (2, 3000000, '2024-08-03'),
    (3, 400000, '2024-08-03'),
    (4, 600000, '2024-09-20'),
    (5, 800000, '2024-09-20');

insert into Order_Details (order_id, product_id, quantity, price_at_time)
values
    (1, 'P001', 1, 20000000),
    (1, 'P003', 1, 250000),
    (2, 'P004', 1, 400000),
    (2, 'P005', 1, 800000),
    (3, 'P003', 2, 250000),
    (4, 'P002', 1, 30000000),
    (5, 'P005', 1, 800000),
    (6, 'P001', 1, 20000000),
    (7, 'P002', 1, 30000000),
    (8, 'P004', 1, 400000),
    (9, 'P003', 2, 250000),
    (10, 'P005', 1, 800000);

-- 2.4 Cập nhật dữ liệu

update Products
set stock = 3
where product_id = 'P002';

update Categories
set category_name = 'Thời trang & Phụ kiện'
where category_name = 'Thời trang';

-- 2.5 Xoá danh mục

delete from Categories
where category_name = 'Sách';

-- Bai 02 Truy vấn dữ liệu

-- 2.1. Truy vấn cơ bản
-- Liệt kê tất cả người dùng trong hệ thống.
select * from Users;
-- Liệt kê tên và giá của tất cả sản phẩm.
select product_name, product_price from Products;
-- Liệt kê tên danh mục và mô tả.
select category_name, category_description from Categories;
-- Liệt kê mã sản phẩm, tên và số lượng tồn kho.
select product_id, product_name, stock from Products;
-- Liệt kê đơn hàng gồm order_id, user_id, total_amount.
select order_id, user_id, order_total_amount from Orders;
-- Liệt kê các bản ghi trong bảng Order_Detail.
select * from Order_Details;

-- 2.2. Truy vấn có điều kiện

-- Liệt kê người dùng có email kết thúc bằng “@gmail.com”.
select * from Users where email like '%@gmail.com';
-- Liệt kê sản phẩm có giá trên 1 triệu đồng.
select * from Products where product_price > 1000000;
-- Liệt kê đơn hàng có tổng tiền lớn hơn 5 triệu.
select * from Orders where order_total_amount > 5000000;
-- Liệt kê sản phẩm còn hàng (stock > 0).
select * from Products where stock > 0;
-- Liệt kê đơn hàng được tạo sau ngày 2024-06-05.
select * from Orders where order_created_at > '2024-06-05';
-- Liệt kê danh mục có tên là “Sách”.
select * from Categories where category_name like 'Sách';

-- 2.3. Truy vấn có nhóm dữ liệu

-- Đếm số lượng sản phẩm thuộc mỗi danh mục.
select c.category_name, count(p.product_id) as 'Số lượng SP'
from Categories c
         join Products p on c.category_id = p.category_id
group by category_name;
-- Tính tổng số lượng tồn kho theo từng danh mục sản phẩm.
select c.category_name, sum(p.stock) as 'Tổng SL tồn kho'
from Categories c
         join Products p on c.category_id = p.category_id
group by category_name;
-- Tính tổng tiền mỗi người đã đặt hàng (theo user_id).
select user_id, sum(order_total_amount) as total_amount
from Orders
group by user_id;
-- Tính số lượng đơn hàng của mỗi người dùng.
select u.user_id, count(O.quantity) as 'SL đơn hàng'
from Order_Details O
         join Users u on O.order_id = u.user_id
group by user_id;
-- Tính số lượng sản phẩm khác nhau trong từng đơn hàng.
select order_id, count(product_id) as 'SL sản phẩm'
from Order_Details
group by order_id;
-- Liệt kê các người dùng có tổng số tiền đơn hàng > 10 triệu.
select u.user_name, sum(o.order_total_amount) as 'Tổng số tiền đơn hàng'
from Orders o
         join Users u on o.user_id = u.user_id
group by user_name
having sum(order_total_amount) > 10000000;
-- Liệt kê danh mục có tổng số sản phẩm tồn kho > 100.
select c.category_name, sum(p.stock) as 'Tổng số SP tồn kho'
from Categories c
         join Products P on c.category_id = P.category_id
group by category_name
having sum(p.stock) > 100;
-- Liệt kê đơn hàng có nhiều hơn 2 loại sản phẩm.
select order_id, count(product_id) as 'Loại SP'
from Order_Details
group by order_id
having count(distinct product_id) > 2;
-- Liệt kê người dùng có hơn 1 đơn hàng.
select u.user_id, u.user_name, count(o.order_id) as 'Số lượng đơn hàng'
from Users u
         join Orders o on u.user_id = o.user_id
group by u.user_id, u.user_name
having count(o.order_id) > 1;


-- 2.4. Truy vấn sử dụng đầy đủ các mệnh đề

-- Liệt kê 5 sản phẩm có giá cao nhất
select product_id, product_name, product_price
from Products
order by product_price DESC
    limit 5;
-- Liệt kê tên sản phẩm và giá, sắp xếp theo price tăng dần
select product_name, product_price
from Products
order by product_price;
-- Liệt kê tất cả đơn hàng, hiển thị thêm cột VAT = 10% tổng tiền.
select user_id, order_total_amount, (order_total_amount * 0.1) as 'VAT'
from Orders;


-- 2.5. Truy vấn lồng

-- Liệt kê sản phẩm có giá cao hơn giá trung bình của tất cả sản phẩm.
select product_name, product_price
from Products
where product_price > (select avg(product_price)
               from Products);
-- Liệt kê người dùng đã từng đặt ít nhất 1 đơn hàng.
select user_id, user_name
from Users
where user_id in (select user_id
                  from Orders);
-- Liệt kê tên sản phẩm xuất hiện trong đơn hàng có tổng tiền > 20 triệu.
select DISTINCT product_name
from Products
where product_id in (select od.product_id
                     from Order_Details od
                              join Orders O on od.order_id = O.order_id
                     where order_total_amount > 20000000);
-- Liệt kê đơn hàng chứa sản phẩm thuộc danh mục “Điện tử”.
select distinct od.order_id
from Orders od
join Order_Details O on od.order_id = O.order_id
where product_id in (select p.product_id
                   from Products p
                            join Categories C on p.category_id = C.category_id
                   where C.category_name = 'Điện tử'
                  );


