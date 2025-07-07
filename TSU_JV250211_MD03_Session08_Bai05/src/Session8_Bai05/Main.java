package Session8_Bai05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryManagement categoryManagement = new CategoryManagement();
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1: Thêm danh mục");
            System.out.println("2: Hiển thị danh mục");
            System.out.println("3: Cập nhật danh mục");
            System.out.println("4: Xóa danh mục");
            System.out.println("5: Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID danh mục: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên danh mục: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập mô tả danh mục: ");
                    String description = scanner.nextLine();
                    categoryManagement.addCategory(new Category(id, name, description));
                    break;
                case 2:
                    Category[] categories = categoryManagement.findAll();
                    if (categories.length == 0) {
                        System.out.println("Danh sách danh mục trống !");
                        break;
                    }
                    System.out.println("--- DANH SÁCH DANH MỤC ---");
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID danh mục cần cập nhật: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập tên mới: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Nhập mô tả mới: ");
                    String updateDescription = scanner.nextLine();
                    categoryManagement.updateCategory(new Category(updateId, updateName, updateDescription));
                    break;
                case 4:
                    System.out.print("Nhập ID danh mục cần xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    categoryManagement.deleteById(deleteId);
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số trong khoảng từ 1 đến 5!");
            }

        } while (choice != 5);
    }
}
