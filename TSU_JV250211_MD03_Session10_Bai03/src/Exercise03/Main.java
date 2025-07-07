package Exercise03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("====================MENU QUẢN LÝ NGƯỜI DÙNG==================");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xoá người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        userManager.addUser(scanner);
                        break;
                    case 2:
                        userManager.removeUser(scanner);
                        break;
                    case 3:
                        userManager.displayUsers();
                        break;
                    case 4:
                        System.out.println("Kết thúc chương trình");
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-4");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-4");
                choice = -1;
                continue;
            }
        } while (choice != 4);
    }
}
