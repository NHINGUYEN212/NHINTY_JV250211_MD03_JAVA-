package ra.entity;

import java.util.Scanner;

public class Categories implements IShop {
    private int catalogId;
    private String categoryName;
    private String descriptions;
    private Boolean catalogStatus;

    public Categories() {
        super();
    }

    public Categories(int catalogId, String categoryName, String descriptions, Boolean catalogStatus) {
        this.catalogId = catalogId;
        this.categoryName = categoryName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }


    //    Ham tang id
    public int incrementId(Categories[] arrCategories, int categoryIndex) {
        int maxId = 0;
        for (int i = 0; i < categoryIndex; i++) {
            if (arrCategories[i].getCatalogId() > maxId) {
                maxId = arrCategories[i].getCatalogId();
            }
        }
        return maxId + 1;
    }

    //    Ham nhap ten danh muc
    public String inputCatalogName(Scanner scanner, Categories[] arrCategories, int categoryIndex) {
        do {
            System.out.println("Nhập tên danh mục:");
            String catalogName = scanner.nextLine();
            if (catalogName.isBlank()) {
                System.err.println("Tên danh mục không được để trống!");
            } else {
                if (catalogName.length() > 50) {
                    System.err.println("Tên danh mục không được vượt quá 50 ký tự!");
                } else {
                    boolean isExist = false;
                    for (int i = 0; i < categoryIndex; i++) {
                        if (catalogName.equals(arrCategories[i].getCategoryName())) {
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        return catalogName;

                    } else {
                        System.err.println("Tên danh mục đã tồn tại. Vui lòng nhập lại!");
                    }
                }
            }

        } while (true);
    }

    //    Ham nhap trang thai danh muc
    public boolean inputCatalogStatus(Scanner scanner) {
        do {
            System.out.println("Nhập trạng thái danh mục (true-hoạt động, false-không hoạt động):");
            String catalogStatus = scanner.nextLine();
            if (catalogStatus.isBlank()) {
                System.err.println("Trạng thái danh mục không được để trống!");
            } else {
                if (catalogStatus.equalsIgnoreCase("true") || catalogStatus.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(catalogStatus);
                } else {
                    System.err.println("Vui lòng nhập đúng định dạng (true || false)!)");
                }
            }

        } while (true);


    }

    //    Ham nhap thong tin dau vao
    public void inputData(Scanner scanner, Categories[] arrCategories, int categoryIndex) {
        this.catalogId = incrementId(arrCategories, categoryIndex);
        this.categoryName = inputCatalogName(scanner, arrCategories, categoryIndex);
        System.out.println("Nhập mô tả:");
        this.descriptions = scanner.nextLine();
        this.catalogStatus = inputCatalogStatus(scanner);

    }

    //     Ham hien thi thong tin day du
    @Override
    public void displayData() {
        System.out.printf("Id: %s, Name: %s, Description: %s, Status: %s%n", this.catalogId, this.categoryName, this.descriptions == null || this.descriptions.isBlank() ? "Không có mô tả" : this.descriptions, this.catalogStatus ? "Hoạt động" : "Không hoạt động");
    }

}
