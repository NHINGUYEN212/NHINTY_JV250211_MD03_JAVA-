import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập địa chỉ email: ");
        String email = scanner.nextLine().trim();
        String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+(\\.[a-zA-Z]{2,6})+$";
        if (email.matches(emailRegex)) {
            System.out.println("Email hợp lệ.");
        } else {
            System.out.println("Email không hợp lệ.");
        }
        scanner.close();
    }
}