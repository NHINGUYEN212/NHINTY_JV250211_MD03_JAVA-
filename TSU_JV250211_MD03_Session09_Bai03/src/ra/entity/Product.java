package ra.entity;

import ra.presentation.ShopManagement;

import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    //    Ham nhap Id
    public String inputProductId(Scanner scanner, Product[] arrProducts, int productIndex) {
        do {
            System.out.println("Nhập mã Id cho sản phẩm đồ uống, gồm 4 ký tự bắt đầu là một trong 3 ký tự (C: các đồ uống là café, S: các đồ uống là sinh tố, A: các đồ ăn nhanh)");
            String productId = scanner.nextLine();
            String productRegex = "^[CSA]\\w{3}$";
            if (productId.matches(productRegex)) {
                boolean isExist = false;
                for (int i = 0; i < productIndex; i++) {
                    if (arrProducts[i].getProductId().equals(productId)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    return productId;
                } else {
                    System.err.println("Mã Id đã tồn tại. Vui lòng nhập Id khác!");
                }
            }
            System.err.println("Mã Id không hợp lệ. Vui lòng nhập lại!");
        } while (true);
    }

//    Ham nhap ten san pham

    public String inputProductName(Scanner scanner, Product[] arrProducts, int productIndex) {
        do {
            System.out.println("Nhập tên sản phẩm:");
            String productName = scanner.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < productIndex; i++) {
                    if (arrProducts[i].getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    return productName;
                } else {
                    System.err.println("Tên sản phẩm đã tồn tại. Vui lòng nhập tên khác!");
                }
            }
            System.err.println("Tên sản phẩm có độ dài 10-50 ký tự. Vui lòng nhập lại!");

        } while (true);
    }

    //    Ham nhap gia
    public float inputProductPrice(Scanner scanner) {
        do {
            System.out.println("Nhập giá sản phẩm:");
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0) {
                return price;
            }
            System.err.println("Giá sản phẩm phải lớn hơn 0. Vui lòng nhập lại!");
        } while (true);
    }

//    Nhap ma danh muc ma san pham thuoc ve

    public int inputCatalogId(Scanner scanner, Categories[] arrCategories, int categoryIndex) {
        do {
            for (int i = 0; i < categoryIndex; i++) {
                System.out.printf("ID: %s, Name: %s%n", arrCategories[i].getCatalogId(), arrCategories[i].getCategoryName());
            }
            System.out.println("Nhập ID danh mục muốn chọn:");
            int selectedCatalogId = Integer.parseInt(scanner.nextLine());
            boolean isExist = false;
            for (int i = 0; i < categoryIndex; i++) {
                if (arrCategories[i].getCatalogId() == selectedCatalogId) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                return selectedCatalogId;
            } else {
                System.err.println("Lựa chọn ID không hợp lệ. Vui lòng nhập lại!");
            }

        } while (true);
    }

//    Ham nhap trang thai san pham

    public int inputProductStatus(Scanner scanner) {
        do {
            System.out.println("Nhập trạng thái sản (0|1|2)");
            int productStatus = Integer.parseInt(scanner.nextLine());
            if (productStatus == 0 || productStatus == 1 || productStatus == 2) {
                return productStatus;
            } else {
                System.err.println("Trạng thái không hợp lệ. Vui lòng nhập lại!");
            }
        } while (true);
    }

    //    Ham nhap du lieu và kiem tra dau vao
    public void inputData(Scanner scanner, Product[] arrProducts, int productIndex, Categories[] arrCategories, int categoryIndex) {
        this.productId = inputProductId(scanner, arrProducts, productIndex);
        this.productName = inputProductName(scanner, arrProducts, productIndex);
        System.out.println("Nhập mô tả sản phẩm:");
        this.description = scanner.nextLine();
        this.price = inputProductPrice(scanner);
        this.catalogId = inputCatalogId(scanner, arrCategories, categoryIndex);
        this.productStatus = inputProductStatus(scanner);
    }

//    Ham displayData

    @Override
    public void displayData() {
        System.out.printf("ID: %s, Name: %s, Price: %f, Category: %s%n", this.productId, this.productName, this.price, getCatalogNameById(this.catalogId));
    }

    public String getCatalogNameById(int catalogId) {
        for (int i = 0; i < ShopManagement.categoryIndex; i++) {
            if (catalogId == ShopManagement.arrCategories[i].getCatalogId()) {
                return ShopManagement.arrCategories[i].getCategoryName();
            }
        }
        return null;
    }
}
