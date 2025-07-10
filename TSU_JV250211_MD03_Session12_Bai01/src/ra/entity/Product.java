package ra.entity;

import ra.business.ProductBusiness;

import java.util.Scanner;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner scanner) {
        this.productId = inputProductId();
        this.productName = inputProductName(scanner);
        this.price = inputProductPrice(scanner);
        this.category = inputCategory(scanner);
        this.quantity = inputQuantity(scanner);
    }

    public int inputProductId() {
        if (ProductBusiness.productList.isEmpty()) {
            return 1;
        }
        int max = ProductBusiness.productList.get(0).getProductId();
        for (int i = 0; i < ProductBusiness.productList.size(); i++) {
            if (ProductBusiness.productList.get(i).getProductId() > max) {
                max = ProductBusiness.productList.get(i).getProductId();
            }
        }
        return max + 1;
    }

    public String inputProductName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm:");
        do {
            String productName = scanner.nextLine().trim();
            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExits = false;
                for (Product product : ProductBusiness.productList) {
                    if (product.getProductName().equals(productName)) {
                        isExits = true;
                        break;
                    }
                }
                if (!isExits) {
                    return productName;
                }
                System.err.println("Tên sản phẩm đã tồn tại. Vui lòng nhập tên khác");

            } else {
                System.err.println("Tên sản phẩm có 10-50 ký tự. Vui lòng nhập lại!");
            }

        } while (true);
    }

    public float inputProductPrice(Scanner scanner) {
        System.out.println("Nhập vào giá sản phẩm:");
        do {
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    return price;
                }
                System.err.println("Giá sản phẩm phải lớn hơn 0. Vui lòng nhập lại");
            } catch (NumberFormatException e) {
                System.err.println("Giá sản phẩm phải là số thực. Vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputCategory(Scanner scanner) {
        System.out.println("Nhập vào danh mục của sản phẩm:");
        do {
            String category = scanner.nextLine().trim();
            if (category.isEmpty()) {
                System.err.println("Tên danh mục không được để trống.");
            } else if (category.length() <= 200) {
                return category;
            } else {
                System.err.println("Tên danh mục có độ dài tối đa 200 ký tự. Vui lòng nhập lại! ");
            }
        } while (true);
    }

    public int inputQuantity(Scanner scanner) {
        System.out.println("Nhập vào số lượng tồn kho của sản phẩm:");
        do {
            try {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 0) {
                    return quantity;
                }
                System.out.println("Số lượng tồn kho phải >= 0");
            } catch (NumberFormatException e) {
                System.err.println("Số lượng tồn kho là số nguyên. Vui lòng nhập lại!");
            }

        } while (true);
    }

    @Override
    public String toString() {
        return String.format("Mã SP: %d - Tên SP: %s - Giá : %.2f - Danh mục: %s - Số lượng: %d\n", productId, productName, price, category, quantity);
    }
}
