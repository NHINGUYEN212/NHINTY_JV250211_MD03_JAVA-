package Exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InvoiceManager invoiceManager = new InvoiceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=============MENU QUẢN LÝ HOÁ ĐƠN================");
            System.out.println("1. Thêm hoá đơn");
            System.out.println("2. Sửa hoá đơn");
            System.out.println("3. Xoá hoá đơn");
            System.out.println("4. Hiển thị danh sách hoá đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Invoice invoice = new Invoice();
                        invoice.inputData(scanner);
                        invoiceManager.add(invoice);
                        break;
                    case 2:
                        invoiceManager.updateById(scanner);
                        break;
                    case 3:
                        invoiceManager.deleteById(scanner);
                        break;
                    case 4:
                        invoiceManager.display();
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
