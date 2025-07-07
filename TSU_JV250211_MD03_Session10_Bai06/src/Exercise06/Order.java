package Exercise06;

import java.util.Scanner;

public class Order {
    private String orderCode;
    private String customerName;

    public Order() {
    }

    public Order(String orderCode, String customerName) {
        this.orderCode = orderCode;
        this.customerName = customerName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void display() {
        System.out.printf("Mã đơn hàng: %s, Tên khách hàng: %s%n", orderCode, customerName);
    }

    private String inputOrderCode(Scanner scanner) {
        String input = "";
        while (true) {
            System.out.println("Nhập mã đơn hàng: ");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.err.println("Không được để trống");
                continue;
            } else {
                return input;
            }
        }

    }

    private String inputCustomerName(Scanner scanner) {
        String input = "";
        while (true) {
            System.out.println("Nhập tên khách hàng: ");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.err.println("Không được để trống");
                continue;
            } else {
                return input;
            }
        }
    }

    public void inputData(Scanner scanner) {
        this.orderCode = inputOrderCode(scanner);
        this.customerName = inputCustomerName(scanner);
    }
}
