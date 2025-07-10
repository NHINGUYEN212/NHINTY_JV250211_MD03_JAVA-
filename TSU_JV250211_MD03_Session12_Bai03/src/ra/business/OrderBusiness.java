package ra.business;

import ra.entity.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderBusiness {
    public static List<Order> orderList = new ArrayList<>();

    public static void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        order.setStatus("Pending");
        orderList.add(order);
    }

    public static void displayOrders() {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng trống");
        }
        orderList.stream().sorted(Comparator.comparing(Order::getOrderAmount)).forEach(System.out::println);
    }

    public static void updateOrder(Scanner scanner) {
        System.out.println("Nhập vào mã đơn hàng cần cập nhật trạng thái:");
        int updateOrderId = Integer.parseInt(scanner.nextLine());
        Order findOrder = null;
        for (Order order : orderList) {
            if (order.getOrderId() == updateOrderId) {
                findOrder = order;
                break;
            }
        }
        if (findOrder == null) {
            System.err.println("Không tìm thấy mã đơn hàng cần cập nhật");
        } else {
            String updateStatus = findOrder.getStatus();
            switch (updateStatus) {
                case "Pending":
                    findOrder.setStatus("Shipped");
                    System.out.println("Trạng thái đơn hàng đã được cập nhật từ Pending -> Shipped");
                    break;
                case "Shipped":
                    findOrder.setStatus("Delivered");
                    System.out.println("Trạng thái đơn hàng đã được cập nhật từ Shipped -> Delivered");
                    break;
                case "Delivered":
                    System.out.println("Đơn hàng đã giao xong, không thể cập nhật");
                    break;
                default:
                    System.err.println("Trạng thái đơn hàng không hợp lệ");
            }
        }
    }

    public static void deleteOrder(Scanner scanner) {
        System.out.println("Nhập vào mã đơn hàng cần xoá:");
        int deleteOrderId = Integer.parseInt(scanner.nextLine());
        Optional<Order> optionalOrder = orderList.stream().filter(o -> o.getOrderId() == deleteOrderId).findFirst();
        optionalOrder.ifPresentOrElse(order -> {
            if (order.getStatus().equals("Pending")) {
                orderList.remove(order);
                System.out.println("Đơn hàng đã được xoá thành công");
            } else {
                System.err.println("Chỉ có thể xoá đơn hàng ở trạng thái Pending");
            }
        }, () -> {
            System.err.println("Không tìm thấy mã đơn hàng cần xoá");
        });
    }

    public static void searchOrderByCustomerName(Scanner scanner) {
        System.out.println("Nhập vào tên khách hàng:");
        String searchCustomerName = scanner.nextLine();
        List<Order> matchList = orderList.stream().filter(o -> o.getCustomerName().toLowerCase().contains(searchCustomerName.toLowerCase())).toList();
        if (matchList.isEmpty()) {
            System.out.println("Không tìm thấy đơn hàng nào với tên khách hàng:" + searchCustomerName);
        } else {
            System.out.println("Tìm thấy các đơn hàng:");
            matchList.forEach(System.out::println);
        }
    }

    public static void statisticsOrder() {
        long totalOrder = orderList.stream().count();
        System.out.println("Tổng số đơn hàng: " + totalOrder);
    }

    public static void totalAmountOfDeliveredOrder() {
        float totalAmount = orderList.stream().filter(order -> order.getStatus().equals("Delivered")).map(Order::getOrderAmount).reduce(0f, Float::sum);
        System.out.println("Tổng doanh thu từ các đơn hàng Delivered: " + totalAmount);
    }

    public static void statisticsOrdersByStatus() {
        Map<String, Long> quantityByStatus = orderList.stream().collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
        System.out.println("Số lượng đơn hàng theo từng trạng thái:");
        quantityByStatus.forEach((status, count) -> System.out.println(status + ": " + count));
    }

    public static void findMaxAmountOfOrder() {
        System.out.println("Đơn hàng có giá trị lớn nhất:");
        orderList.stream().max(Comparator.comparing(Order::getOrderAmount)).ifPresent(System.out::println);
    }
}
