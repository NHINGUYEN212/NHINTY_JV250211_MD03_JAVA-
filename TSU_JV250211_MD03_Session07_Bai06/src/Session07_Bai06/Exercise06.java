package Session07_Bai06;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise06 {
    private static ArrayList<Category> categoryList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public  static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lỗi. Lựa chọn phải là một số. Vui lòng nhập lại!");
                choice = -1;
            }
            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    displayCategories(categoryList);
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    searchCategoryByName();
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.err.println("Lỗi. Lựa chọn không hợp lệ. Vui lòng nhập số trong khoảng từ 1 đến 6!");
            }


        } while (choice != 6);
        scanner.close();
    }

    //In Menu
    public static void printMenu() {
        System.out.println("***************MENU***************");
        System.out.println("1: Thêm mới danh mục");
        System.out.println("2: Hiển thị danh sách danh mục");
        System.out.println("3: Cập nhật danh mục");
        System.out.println("4: Xoá danh mục");
        System.out.println("5. Tìm kiếm danh mục theo tên");
        System.out.println("6: Thoát");
    }

    //Ham tim kiem theo ID
    public static  Category findCategoryById(String id) {
        for (Category category : categoryList) {
            if (category.getId().equalsIgnoreCase(id)) {
                return category;
            }
        }
        return null;
    }
    //    Chuc nang 1
    public static void addCategory() {
        System.out.println("--- THÊM SẢN DANH MỤC ---");
        String id;
        while (true) {
            System.out.print("Nhập ID danh mục: ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.err.println("Lỗi: ID không được để trống.");
            } else if (findCategoryById(id) != null) {
                System.err.println("Lỗi: ID này đã tồn tại. Vui lòng nhập ID khác.");
            }  else {
                break;
            }
        }
        System.out.print("Nhập tên danh mục: ");
        String name = scanner.nextLine().trim();
        System.out.print("Nhập mô tả cho danh mục: ");
        String description = scanner.nextLine().trim();

        Category category = new Category(id, name, description);
        categoryList.add(category);
        System.out.println("Danh mục đã được thêm.");
    }

//    Chuc nang 2: Hien thi danh sach danh muc

    public static void displayCategories(ArrayList<Category> categoryList) {
        System.out.println("---DANH SÁCH DANH MỤC---");
        if (categoryList.isEmpty()) {
            System.out.println("Danh sách danh mục trống.");
            return;
        } else  {
            for (Category category : categoryList) {
                System.out.println("ID: " + category.getId() + ", Tên: " + category.getName() + ", Mô tả: " + category.getDescription());
            }
        }
    }

//    Chuc nang 3: Cap nhat danh muc

    public static void updateCategory() {
        System.out.println("--- CẬP NHẬT DANH MỤC ---");
        System.out.print("Nhập ID danh mục cần cập nhật: ");
        String id = scanner.nextLine().trim();

        Category categoryToUpdate = findCategoryById(id);
        if (categoryToUpdate == null) {
            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
            return;
        }
        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            categoryToUpdate.setName(newName);
        }

        System.out.print("Nhập mô tả mới: ");
        String newDescription = scanner.nextLine().trim();
        if (!newDescription.isEmpty()) {
            categoryToUpdate.setDescription(newDescription);
        }


        System.out.println("Danh mục đã được cập nhật.");
    }

//    Chuc nang 4: Xoa danh muc

    public static void deleteCategory() {
        System.out.println("--- XÓA DANH MỤC ---");
        System.out.print("Nhập ID danh mục cần xóa: ");
        String id = scanner.nextLine().trim();

        Category categoryToDelete = findCategoryById(id);
        if (categoryToDelete == null) {
            System.out.println("Không tìm thấy danh mục với ID: " + id);
            return;
        }
        categoryList.remove(categoryToDelete);
        System.out.println("Danh mục đã được xoá.");
    }

//    Chuc nang 5: Tim kiem theo ten

    public static void searchCategoryByName() {
        System.out.println("--- TÌM KIẾM DANH MỤC THEO TÊN ---");
        if (categoryList.isEmpty()) {
            System.out.println("Danh sách trống, không thể tìm kiếm.");
            return;
        }
        System.out.print("Nhập tên danh mục cần tìm: ");
        String searchTerm = scanner.nextLine().trim().toLowerCase();
        ArrayList<Category> foundCategories = new ArrayList<>();
        for (Category category : categoryList) {
            if (category.getName().toLowerCase().contains(searchTerm)) {
                foundCategories.add(category);
            }
        }
        if (foundCategories.isEmpty()) {
            System.out.println("Không tìm thấy danh mục nào khớp với tên: " + searchTerm);
            return;
        } else {
            System.out.println("Các danh mục tìm thấy:");
            displayCategories(foundCategories);
        }
    }
}
