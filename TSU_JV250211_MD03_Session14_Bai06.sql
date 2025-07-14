CREATE database session14_6;
USE session14_6;

-- Tạo bảng employees
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY, 
    full_name VARCHAR(100) NOT NULL,            
    `position` VARCHAR(50) NOT NULL,              
    salary DECIMAL(10, 2) NOT NULL,             
    hire_date DATE NOT NULL,                    
    department VARCHAR(50) NOT NULL            
);

-- Thêm bản ghi vào employees
INSERT INTO employees (full_name, `position`, salary, hire_date, department)
VALUES
('Nguyen Van An', 'Software Engineer', 15000000.00, '2022-05-01', 'IT'),
('Tran Thi Bich', 'HR Specialist', 12000000.00, '2021-03-15', 'Human Resources'),
('Le Van Cuong', 'Sales Manager', 18000000.00, '2020-11-20', 'Sales'),
('Pham Minh Hoang', 'Marketing Specialist', 14000000.00, '2023-01-10', 'Marketing'),
('Do Thi Ha', 'Accountant', 13000000.00, '2021-07-25', 'Finance'),
('Hoang Quang Huy', 'Project Manager', 20000000.00, '2019-06-05', 'IT');

-- Tìm các nhân viên có mức lương cao hơn mức lương trung bình của tất cả các nhân viên.
-- Kết quả gồm: tên đầy đủ (full_name), chức vụ (position), mức lương (salary)
select full_name, `position`, salary
from employees
where salary >(
      select avg(salary)
      from employees
      );

-- Tìm tên các nhân viên và phòng ban của họ, nơi tổng số nhân viên trong phòng ban đó lớn hơn hoặc bằng 2.
-- Kết quả gồm: tên đầy đủ (full_name), phòng ban (department).
select full_name, department
from employees
where department in (
		select department 
        from employees
        group by department
        having count(*) >= 2
        );
        
-- Tìm nhân viên có mức lương cao nhất trong từng phòng ban.
-- Kết quả gồm: tên đầy đủ (full_name), phòng ban (department), mức lương (salary).
select full_name, department, salary
from employees as Em1  -- bảng chính (nhân viên hiện tại).
-- Mỗi dòng của bảng Em1 sẽ được so sánh với một truy vấn con để kiểm tra điều kiện.
-- lọc ra những nhân viên có salary bằng với mức cao nhất trong phòng ban của họ.
where salary =(
		select max(salary)
        from employees as Em2 
        where Em1.department=Em2.department 
        );
        
-- Tìm phòng ban có ngày tuyển dụng sớm nhất (ngày cũ nhất) và hiển thị thông tin nhân viên được tuyển dụng đầu tiên trong từng phòng ban.
-- Kết quả gồm: tên đầy đủ (full_name), phòng ban (department), ngày tuyển dụng (hire_date)
select full_name, department, hire_date
from employees
where (department, hire_date) in (
		select department, min(hire_date) 
        from employees
        group by department
		 );