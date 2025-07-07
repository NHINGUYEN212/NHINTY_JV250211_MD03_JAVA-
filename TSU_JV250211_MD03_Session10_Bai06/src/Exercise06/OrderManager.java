package Exercise06;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager implements Manage<Order> {
    public ArrayList<Order> orders;
    public OrderManager() {
        orders = new ArrayList<>();
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }
    @Override
    public void update(int index, Order order) {
        if (index >= 0 && index < orders.size()) {
            orders.set(index, order);
        } else {
            throw new IndexOutOfBoundsException("Mã đơn hàng không tồn tại");
        }
    }
    @Override
    public void delete(int index) {
        if (index >= 0 && index < orders.size()) {
            orders.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Mã đơn hàng không tồn tại");
        }
    }
    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống");
        } else {
            for (int i=0; i<orders.size(); i++) {
                orders.get(i).display();
            }
        }
    }

    private int findIndexByOrderCode(String orderCode) {
        for (int i=0; i<orders.size(); i++) {
            if (orders.get(i).getOrderCode().equals(orderCode)) {
                return i;
            }
        }
        return -1;
    }
    public void updateByOrderCode(Scanner scanner) {
        System.out.println("Nhập mã đơn hàng cần sửa:");
        String updateOrderCode = scanner.nextLine();
        int index = findIndexByOrderCode(updateOrderCode);
        if (index == -1) {
            System.err.println("Không tìm thấy mã đơn hàng cần sửa");
        } else {
            while (true) {
                System.out.println("Nhập tên khách hàng mới");
                String updateCustomerName = scanner.nextLine();
                if (updateCustomerName.isEmpty()) {
                    System.err.println("Không được để trống");
                    continue;
                } else {
                    orders.get(index).setCustomerName(updateCustomerName);
                    System.out.println("Đơn hàng dã được sửa thành công");
                    break;
                }
            }
        }
    }

    public void deleteByOrderCode(Scanner scanner) {
            System.out.println("Nhập mã đơn hàng xoá:");
            String orderCode = scanner.nextLine();
            int index = findIndexByOrderCode(orderCode);
            if (index == -1) {
                System.out.println("Không tìm thấy đơn hàng cần xoá");
            } else {
                orders.remove(index);
                System.out.println("Xoá đơn hàng thành công");
            }
    }
}
