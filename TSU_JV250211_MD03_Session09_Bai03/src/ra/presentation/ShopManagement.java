package ra.presentation;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    public static Categories[] arrCategories = new Categories[100];
    public static Product[] arrProducts = new Product[100];
    public static int categoryIndex = 0;
    public static int productIndex = 0;

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************SHOP MENU************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayMenuCategories(scanner);
                    break;
                case 2:
                    displayMenuProduct(scanner);
                    break;
                case 3:
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-3!");
            }


        } while (choice != 3);
    }

    public static void displayMenuCategories(Scanner scanner) {
        int choice;
        do {
            System.out.println("************CATEGORIES MENU************");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xoá danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addCategory(scanner);
                    break;
                case 2:
                    displayCategories();
                    break;
                case 3:
                    updateCategory(scanner);
                    break;
                case 4:
                    deleteCategory(scanner);
                    break;
                case 5:
                    updateCategoryStatus(scanner);
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-3!");
            }

        } while (choice != 6);
    }

    public static void displayMenuProduct(Scanner scanner) {
        do {
            System.out.println("************PRODUCTS MENU************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xoá sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm  các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a - b");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProducts(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    productSortByPrice();
                    break;
                case 4:
                    updateProductById(scanner);
                    break;
                case 5:
                    deleteProductById(scanner);
                    break;
                case 6:
                    searchProductByName(scanner);
                    break;
                case 7:
                    searchProductByPrice(scanner);
                    break;
                case 8:
                    break;

                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-3!");
            }

        } while (true);
    }

//    ================= DANH MUC ====================

    //    Phuong thuc tim kiem theo Id
    public static int findIndexById(int catalogId) {
        for (int i = 0; i < categoryIndex; i++) {
            if (catalogId == arrCategories[i].getCatalogId()) {
                return i;
            }
        }
        return -1;
    }
//    chuc nang 1: Nhap thong tin danh muc

    public static void addCategory(Scanner scanner) {
        System.out.print("Nhập số lượng danh mục muốn thêm: ");
        int categoryQuantities = Integer.parseInt(scanner.nextLine());
        if (categoryQuantities + categoryIndex > arrCategories.length) {
            System.err.println("Không đủ chỗ trong mảng để thêm danh mục mới!");
            return;
        }
        for (int i = 0; i < categoryQuantities; i++) {
            arrCategories[categoryIndex] = new Categories();
            arrCategories[categoryIndex].inputData(scanner, arrCategories, categoryIndex);
            categoryIndex++;
        }
    }

    //  Chuc nang 2: Hien thi danh muc
    public static void displayCategories() {
        if (categoryIndex == 0) {
            System.out.println("Danh sách danh mục trống");
            return;
        }
        for (int i = 0; i < categoryIndex; i++) {
            arrCategories[i].displayData();
        }

    }

    //    Chuc nang 3: cap nhat thong tin danh muc
    public static void updateCategory(Scanner scanner) {
        int choice;
        System.out.println(" mã danh mục cần cập nhật:");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int updateIndex = findIndexById(catalogId);
        if (updateIndex == -1) {
            System.err.println("Không tìm thấy danh mục");
            return;
        }
        do {
            System.out.println("===========CATEGORY UPDATE MENU==============");
            System.out.println("1. Cập nhật tên danh mục");
            System.out.println("2. Cập nhật mô tả");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên danh mục mới");
                    arrCategories[updateIndex].setCategoryName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập mô tả mới:");
                    arrCategories[updateIndex].setDescriptions(scanner.nextLine());
                    break;
                case 3:
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-3");
            }
        } while (choice != 3);
    }

    //    Chuc nang 4: xoa danh muc
    public static void deleteCategory(Scanner scanner) {
        System.out.println("Nhập mã danh mục muốn xoá:");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int deleteIndex = findIndexById(deleteId);
        if (deleteIndex == -1) {
            System.err.println("Không tìm thấy danh mục");
            return;
        }
        for (int i = deleteIndex; i < categoryIndex - 1; i++) {
            arrCategories[i] = arrCategories[i + 1];
        }
        categoryIndex--;
        System.out.printf("Đã xoá thành  danh mục có Id %s%n", deleteId);
    }

//    Chuc nang 5: Cap nhat trang thai danh muc

    public static void updateCategoryStatus(Scanner scanner) {
        System.out.println("Nhập mã danh mục cần cập nhật trạng thái:");
        int updateStatusId = Integer.parseInt(scanner.nextLine());
        int updateStatusIndex = findIndexById(updateStatusId);
        if (updateStatusIndex == -1) {
            System.err.println("Không tìm thấy danh mục");
            return;
        }
        System.out.println("Nhập trạng thái mới (true|false):");
        boolean updateCatalogStatus = Boolean.parseBoolean(scanner.nextLine());
        arrCategories[updateStatusIndex].setCatalogStatus(updateCatalogStatus);
        System.out.println("Cập nhật trạng thái thành công");
    }

    //    ================= SẢN PHẨM ====================
//  PHUONG THUC TIM KIEM SAN PHAM THEO ID
    public static int findIndexOfProductById(String productId) {
        for (int i = 0; i < productIndex; i++) {
            if (arrProducts[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    //    CHUC NANG 1: Nhap thong tin cac san pham
    public static void addProducts(Scanner scanner) {
        System.out.println("Nhập số lượng sản phẩm muốn thêm:");
        int productQuantities = Integer.parseInt(scanner.nextLine());
        if (productQuantities + productIndex > arrProducts.length) {
            System.err.println("Không đủ chỗ trong mảng để thêm sản phẩm mới");
            return;
        }
        for (int i = 0; i < productQuantities; i++) {
            arrProducts[productIndex] = new Product();
            arrProducts[productIndex].inputData(scanner, arrProducts, productIndex, arrCategories, categoryIndex);
            productIndex++;
        }
    }

//    CHUC NANG 2: HIEN THI SAN PHAM

    public static void displayProducts() {
        if (productIndex == 0) {
            System.out.println("Danh sách sản phẩm trống");
            return;
        }
        for (int i = 0; i < productIndex; i++) {
            arrProducts[i].displayData();
        }
    }

//    CHUC NANG 3: SAP XEP THEO GIA

    public static void productSortByPrice() {
        for (int i = 0; i < productIndex - 1; i++) {
            for (int j = 0; j < productIndex - 1; j++) {
                if (arrProducts[j].getPrice() > arrProducts[j + 1].getPrice()) {
                    Product temp = arrProducts[j];
                    arrProducts[j] = arrProducts[j + 1];
                    arrProducts[j + 1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần");
        for (int i = 0; i < productIndex; i++) {
            arrProducts[i].displayData();
        }
    }

//    CHUC NANG 4:CAP NHAT THONG TIN THEO MA SAN PHAM

    public static void updateProductById(Scanner scanner) {
        int choice;
        do {
            System.out.println("Nhập mã sản phẩm cần cập nhật");
            String productId = scanner.nextLine();
            int updateIndex = findIndexOfProductById(productId);
            if (updateIndex == -1) {
                System.err.println("Không tìm thấy sản phẩm");
                return;
            }

            System.out.println("===========PRODUCT UPDATE MENU==============");
            System.out.println("1. Cập nhật tên sản phẩm");
            System.out.println("2. Cập nhật giá sản phẩm");
            System.out.println("3. Cập nhật mô tả cho sản phẩm");
            System.out.println("4. Cập nhật trạng thái sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên mới");
                    arrProducts[updateIndex].setProductName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập giá mới");
                    arrProducts[updateIndex].setPrice(Float.parseFloat(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Nhập mô tả mới");
                    arrProducts[updateIndex].setDescription(scanner.nextLine());

                    break;
                case 4:
                    System.out.println("Nhập trạng thái mới");
                    arrProducts[updateIndex].setProductStatus(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn tù 1-5");
            }
        } while (choice != 5);
    }

//    CHUC NANG 5: XOA SAN PHAM THEO ID

    public static void deleteProductById(Scanner scanner) {
        System.out.println("Nhập Id sản phẩm cần xoá:");
        String deleteProductId = scanner.nextLine();
        int deleteIndex = findIndexOfProductById(deleteProductId);
        if (deleteIndex == -1) {
            System.err.println("Không tìm thấy sản phẩm");
            return;
        }
        for (int i = deleteIndex; i < productIndex - 1; i++) {
            arrProducts[i] = arrProducts[i + 1];
        }
        productIndex--;
        System.out.println("Xoá thành công");

    }

//    CHUC NANG 6: TIM KIEM THEO TEN SAN PHAM

    public static void searchProductByName(Scanner scanner) {
        boolean found = false;
        System.out.println("Nhập tên sản phẩm cần tìm kiếm:");
        String searchProductName = scanner.nextLine();
        for (int i = 0; i < productIndex; i++) {
            if (arrProducts[i].getProductName().toLowerCase().contains(searchProductName.toLowerCase())) {
                arrProducts[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào với tên đã nhập");
        }
    }

//    CHUC NANG 7: TIM SAN PHAM TRONG KHOANG GIA A - B

    public static void searchProductByPrice(Scanner scanner) {
        System.out.println("Nhập giá bắt đầu (a):");
        Float priceA = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá kết thúc (b):");
        Float priceB = Float.parseFloat(scanner.nextLine());

        if (priceA > priceB) {
            float temp = priceA;
            priceA = priceB;
            priceB = temp;
        }
        boolean found = false;
        for (int i = 0; i < productIndex; i++) {
            if (arrProducts[i].getPrice() >= priceA && arrProducts[i].getPrice() <= priceB) {
                arrProducts[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào trong khoảng giá.");
        }

    }

}
