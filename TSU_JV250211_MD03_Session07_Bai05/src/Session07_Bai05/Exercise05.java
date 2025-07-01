package Session07_Bai05;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise05 {
    private static ArrayList<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lỗi. Lựa chọn phải là một . Vui lòng nhập lại!");
                choice = -1;
            }
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.err.println("Lỗi. Lựa chọn không hợp lệ. Vui lòng nhập số trong khoảng từ 1 đến 5!");
            }

        } while (choice != 5);
        scanner.close();

    }
//In Menu
    public static void printMenu() {
        System.out.println("***************MENU***************");
        System.out.println("1: Thêm mới sản phẩm");
        System.out.println("2: Hiển thị danh sách sản phẩm");
        System.out.println("3: Cập nhật sản phẩm");
        System.out.println("4: Xoá sản phẩm");
        System.out.println("5: Thoát");
    }

//Ham tim kiem theo ID
    public static  Product findProductById(String id) {
        for (Product product : productList) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }
//    Chuc nang 1
    public static void addProduct() {
        System.out.println("--- THÊM SẢN PHẨM MỚI ---");
        String id;
        while (true) {
            System.out.print("Nhập ID sản phẩm: ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.err.println("Lỗi: ID không được để trống.");
            } else if (findProductById(id) != null) {
                System.err.println("Lỗi: ID này đã tồn tại. Vui lòng nhập ID khác.");
            }  else {
                break;
            }
        }
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine().trim();
        double price;
        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            try {
                price = Double.parseDouble(scanner.nextLine().trim());
                if (price >= 0) {
                    break;
                } else {
                    System.err.println("Lỗi: Giá sản phẩm phải là một số không âm.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập một số hợp lệ.");
            }
        }

        Product newProduct = new Product(id, name, price);
        productList.add(newProduct);
        System.out.println("Thêm sản phẩm thành công!");
    }

//    Chuc nang 2: Hien thi danh sach san pham

    public static void displayProducts() {
        System.out.println("---DANH SÁCH SẢN PHẨM---");
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        } else  {
            for (Product product : productList) {
                System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá: " + product.getPrice());
            }
        }
    }

//    Chuc nang 3: Cap nhat san pham

    public static void updateProduct() {
        System.out.println("--- CẬP NHẬT SẢN PHẨM ---");
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        String id = scanner.nextLine().trim();

        Product productToUpdate = findProductById(id);
        if (productToUpdate == null) {
            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
            return;
        }
        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            productToUpdate.setName(newName);
        }

        System.out.print("Nhập giá mới: ");
        String newPrice = scanner.nextLine().trim();
        if (!newPrice.isEmpty()) {
            productToUpdate.setPrice(Double.parseDouble(newPrice));
        }

        System.out.println("Sản phẩm đã được cập nhật.");
    }

//    Chuc nang 4: Xoa san pham

    public static void deleteProduct() {
        System.out.println("--- XÓA SẢN PHẨM ---");
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        String id = scanner.nextLine().trim();
        Product productToDelete = findProductById(id);
        if (productToDelete == null) {
            System.out.println("Không tìm thấy sản phẩm với ID: " + id);
            return;
        }
        productList.remove(productToDelete);
        System.out.println("Sản phẩm đã được xoá.");
    }

}
