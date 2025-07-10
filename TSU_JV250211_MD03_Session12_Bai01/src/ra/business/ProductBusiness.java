package ra.business;

import ra.entity.Product;

import java.util.*;

public class ProductBusiness {
    public static List<Product> productList = new ArrayList<Product>();

    public static void addProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        productList.add(product);
    }

    public static void displayProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static int findIndexProductById(int productId) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần cập nhật:");
        int productId = Integer.parseInt(scanner.nextLine());
        int updateIndex = findIndexProductById(productId);
        if (updateIndex != -1) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sản phẩm");
                System.out.println("2. Cập nhật giá sản phẩm");
                System.out.println("3. Cập nhật danh mục");
                System.out.println("4. Cập nhật số lượng tồn kho");
                System.out.println("5. Thoát");
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên mới sản phẩm:");
                        productList.get(updateIndex).setProductName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào giá mới sản phẩm:");
                        productList.get(updateIndex).setPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào danh mục mới sản phẩm:");
                        productList.get(updateIndex).setCategory(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập vào số lượng mới sản phẩm:");
                        productList.get(updateIndex).setQuantity(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-5");
                }
            } while (!isExit);
        } else {
            System.err.println("Mã sản phẩm không tồn tại");
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm muốn xoá:");
        int productId = Integer.parseInt(scanner.nextLine());
        int deleteIndex = findIndexProductById(productId);
        if (deleteIndex != -1) {
            productList.remove(deleteIndex);
        } else {
            System.err.println("Mã sản phẩm không tồn tại");
        }
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm muốn tìm:");
        String productName = scanner.nextLine();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                System.out.println(product);
            }
        }
    }

    public static void sortProductByPriceASC() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o1.getPrice(), o2.getPrice());
            }
        });
        System.out.println("Đã sắp xếp xong các sản phẩm theo giá tăng dần");
    }

    public static void sortProductByQuantityDESC() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getQuantity() - o1.getQuantity();
            }
        });
        System.out.println("Đã sắp xếp xong các sản phẩm theo số lượng giảm dần");

    }

}
