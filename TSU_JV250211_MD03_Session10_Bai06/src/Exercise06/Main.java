package Exercise06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=============MENU QUẢN LÝ ĐƠN HÀNG================");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xoá đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Order order = new Order();
                        order.inputData(scanner);
                        orderManager.add(order);
                        break;
                    case 2:
                        orderManager.updateByOrderCode(scanner);
                        break;
                    case 3:
                        orderManager.deleteByOrderCode(scanner);
                        break;
                    case 4:
                        orderManager.display();
                        break;
                    case 5:
                        System.out.println("Kết thúc chương trình");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng nhập lựa chọn từ 1-5");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số từ 1-5");
            }
        } while (true);
    }
}
