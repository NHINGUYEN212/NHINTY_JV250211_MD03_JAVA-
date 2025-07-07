package Exercise04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===============MENU QUẢN LÝ ĐIỂM DANH================");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xoá sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Student student = new Student();
                        student.inputData(scanner);
                        manager.add(student);
                        break;
                    case 2:
                        manager.updateStudentById(scanner);
                        break;
                    case 3:
                        manager.deleteStudentById(scanner);
                        break;
                    case 4:
                        manager.display();
                        break;
                    case 5:
                        System.out.println("Kết thúc chương trình");
                        System.exit(0);
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-5");

                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số từ 1-5");
            }
        } while (true);
    }
}
