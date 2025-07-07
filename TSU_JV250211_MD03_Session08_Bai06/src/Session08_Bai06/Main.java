package Session08_Bai06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Thoát");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tiêu đề: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String author = scanner.nextLine();
                    System.out.print("Nhập ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int year = scanner.nextInt();
                    manager.addBook(new Book(title, author, isbn, year));
                    break;
                case 2:
                    manager.displayBooks();
                    break;
                case 3:
                    System.out.print("Nhập ISBN sách cần xóa: ");
                    String removeId = scanner.nextLine();
                    manager.removeBook(removeId);
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số trong khoảng từ 1 đến 4!");
            }

        } while (choice != 4);
    }
}
