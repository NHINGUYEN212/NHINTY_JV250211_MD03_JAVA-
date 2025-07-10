package ra.entity;

import ra.business.OrderBusiness;

import java.util.Scanner;

public class Order {
    private int orderId;
    private String customerName;
    private String phoneNumber;
    private String address;
    private Float orderAmount;
    private String status;

    public Order() {
    }

    public Order(int orderId, String customerName, String phoneNumber, String address, Float orderAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        this.orderId = incrementOrderId();
        this.customerName = inputCustomerName(scanner);
        this.phoneNumber = inputPhoneNumber(scanner);
        this.address = inputAddress(scanner);
        this.orderAmount = inputOrderAmount(scanner);
    }

    public int incrementOrderId() {
        return OrderBusiness.orderList.stream().mapToInt(Order::getOrderId).max().orElse(0) + 1;
    }

    public String inputCustomerName(Scanner scanner) {
        System.out.println("Nhập vào tên khách hàng:");
        do {
            String name = scanner.nextLine().trim();
            if (name.length() >= 6 && name.length() <= 100) {
                return name;
            }
            System.err.println("Tên khách hàng phải có 6-100 kí tự");
        } while (true);
    }

    public String inputPhoneNumber(Scanner scanner) {
        System.out.println("Nhập vào số điện thoại:");
        do {
            String phoneNumber = scanner.nextLine().trim();
            String phoneNumberRegex = "^(0|\\+84)(?:(3|5|7|8|9)\\d{8}|2\\d{9})$";
            if (phoneNumber.matches(phoneNumberRegex)) {
                return phoneNumber;
            }
            System.err.println("SĐT không đúng định dạng. Vui lòng nhập lại!");
        } while (true);
    }

    public String inputAddress(Scanner scanner) {
        System.out.println("Nhập vào địa chỉ:");
        do {
            String address = scanner.nextLine().trim();
            if (!address.isEmpty()) {
                return address;
            }
            System.err.println("Địa chỉ không được để trống");
        } while (true);
    }

    public Float inputOrderAmount(Scanner scanner) {
        System.out.println("Nhập vào giá trị đơn hàng:");
        do {
            String orderAmount = scanner.nextLine().trim();
            try {
                float amount = Float.parseFloat(orderAmount);
                if (amount > 0) {
                    return amount;
                }
                System.err.println("Giá trị đơn hàng phải lớn hơn 0");

            } catch (NumberFormatException e) {
                System.err.println("Giá trị đơn hàng phải là số thực. Vui lòng nhập lại!");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return String.format("ID: %s - Tên khách hàng: %s - SĐT: %s - Địa chỉ: %s - Giá trị đơn hàng: %.2f - Trạng thái: %s%n", orderId, customerName, phoneNumber, address, orderAmount, status);
    }
}
