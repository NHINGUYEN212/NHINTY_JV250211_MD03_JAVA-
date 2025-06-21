import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mật khẩu cần kiểm tra: ");
        String password = scanner.nextLine().trim();
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        if (password.matches(passwordRegex)) {
            System.out.println("Password hợp lệ.");
        } else {
            System.out.println("Password không hợp lệ.");
        }
        scanner.close();
    }
}