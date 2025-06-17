import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng: ");
        String clientName = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        float productPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số lượng mua: ");
        float quantity = Float.parseFloat(scanner.nextLine());
        System.out.println("Khách hàng có thẻ thành viên hay không? (true/false): ");
        boolean isMember = Boolean.parseBoolean(scanner.nextLine());

        float amount = productPrice * quantity;
        float discount = isMember ? amount * 0.1f : 0;
        float vat = amount * 0.08f;
        float total = amount - discount + vat;

        System.out.println("Khách hàng: " + clientName);
        System.out.println("Sản phẩm: " + productName);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Đơn giá: " + productPrice + " VND");
        System.out.println("Thành tiền: " + amount + " VND");
        System.out.println("Giảm giá thành viên (10%): " + discount + " VND");
        System.out.println("Tiền VAT (8%)" + vat + " VND");
        System.out.println("Tổng thanh toán: " + total + " VND");
    }
}