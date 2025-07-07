package Exercise01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==========MENU============");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        studentManager.addStudent(scanner);
                        System.out.println("Thêm sinh viên thành công");
                        break;
                    case 2:
                        studentManager.displayAllStudents();
                        break;
                    case 3:
                        System.out.println("Kết thúc chương trình");
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên từ 1-3.");
            }

        } while (true);
    }
}
