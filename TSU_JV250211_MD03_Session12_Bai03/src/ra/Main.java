package ra;

import ra.business.OrderBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("==============QUẢN LÝ ĐƠN HÀNG==============");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị danh sách đơn hàng");
            System.out.println("3. Cập nhật trạng thái theo mã đơn hàng");
            System.out.println("4. Xoá đơn hàng theo mã đơn hàng");
            System.out.println("5. Tìm kiếm đơn hàng theo tên khách hàng");
            System.out.println("6. Thống kê tổng số lượng đơn hàng");
            System.out.println("7. Thống kê tổng doanh thu các đơn hàng có trạng thái Delivered");
            System.out.println("8. Thống kê số lượng đơn hàng theo từng trạng thái");
            System.out.println("9. Tìm kiếm đơn hàng có giá trị lớn nhất");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    OrderBusiness.addOrder(scanner);
                    break;
                case 2:
                    OrderBusiness.displayOrders();
                    break;
                case 3:
                    OrderBusiness.updateOrder(scanner);
                    break;
                case 4:
                    OrderBusiness.deleteOrder(scanner);
                    break;
                case 5:
                    OrderBusiness.searchOrderByCustomerName(scanner);
                    break;
                case 6:
                    OrderBusiness.statisticsOrder();
                    break;
                case 7:
                    OrderBusiness.totalAmountOfDeliveredOrder();
                    break;
                case 8:
                    OrderBusiness.statisticsOrdersByStatus();
                    break;
                case 9:
                    OrderBusiness.findMaxAmountOfOrder();
                    break;
                case 10:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-10");
            }
        } while (true);
    }
}
