package Exercise02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("============MENU QUẢN LÝ SÁCH================");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm kiếm sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        bookManager.addBook(scanner);
                        break;
                    case 2:
                        bookManager.findBook(scanner);
                        break;
                    case 3:
                        bookManager.displayAllBooks();
                        break;
                    case 4:
                        System.out.println("Kết thúc chương trình");
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-4");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên từ 1-4");
            }

        } while (true);
    }
}
