insert into readers (name, birthDate, address, phoneNumber) values
('Nguyễn Văn An', '1995-08-12', '123 Đường A, Quận 1, TP.HCM', '0901234567'),
('Trần Thị Bình', '1988-04-25', '456 Đường B, Quận 3, TP.HCM', '0912345678'),
('Lê Văn Cường', '2001-11-30', '789 Đường C, Quận 5, TP.HCM', '0987654321'),
('Phạm Thị Dung', '1974-02-15', '101 Đường D, Quận 10, TP.HCM', '0978123456'),
('Hoàng Văn Em', '1999-07-20', '212 Đường E, Quận Tân Bình, TP.HCM', '0934567890'),
('Vũ Thị Giang', '1990-01-05', '333 Đường G, Quận Bình Thạnh, TP.HCM', '0945678901'),
('Đặng Văn Hùng', '1965-09-18', '555 Đường H, TP. Thủ Đức', '0967890123'),
('Bùi Thị Lan', '1997-03-22', '777 Đường L, Quận 7, TP.HCM', '0989012345'),
('Ngô Văn Mạnh', '1985-12-01', '888 Đường M, Quận Gò Vấp, TP.HCM', '0918765432'),
('Doãn Thị Nga', '2000-06-10', '999 Đường N, Quận 12, TP.HCM', '0909876543');

SET SQL_SAFE_UPDATES = 0;
update readers 
set name = concat(name, 'genZ')
where year(birthDate) between 1990 and 2000;

select * 
from readers 
where year(birthDate) > 1975;