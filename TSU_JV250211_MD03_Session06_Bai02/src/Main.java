import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String fullName = "";
    String email = "";
    String phoneNumber = "";
    String password = "";
        do {
            System.out.println("******************QUẢN LÝ NGƯỜI DÙNG****************");
            System.out.println("1.Nhập thông tin người dùng");
            System.out.println("2.Chuẩn hóa họ tên");
            System.out.println("3.Kiểm tra email hợp lệ");
            System.out.println("4.Kiểm tra số điện thoại hợp lệ");
            System.out.println("5.Kiểm tra mật khẩu hợp lệ");
            System.out.println("6.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Nhập họ và tên:");
                    fullName = scanner.nextLine().trim();
                    System.out.println("Nhập email:");
                    email = scanner.nextLine().trim();
                    System.out.println("Nhập số điện thoại:");
                    phoneNumber = scanner.nextLine().trim();
                    System.out.println("Nhập mật khẩu:");
                    password = scanner.nextLine().trim();
                    break;
                case 2:
                    String trimmedName = fullName.trim().replaceAll("\\s+", " ");
                    String[] words = trimmedName.split(" ");
                    StringBuilder normalizedName = new StringBuilder();
                    for (String word : words) {
                        String capitalizedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
                        normalizedName.append(capitalizedWord).append(" ");
                    }
                    fullName = normalizedName.toString().trim();
                    System.out.println("Họ tên sau khi chuẩn hoá: " + fullName);
                    break;
                case 3:
                    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                    if (Pattern.matches(emailRegex, email)) {
                        System.out.println("Email hợp lệ.");
                    } else {
                        System.out.println("Email không hợp lệ.");
                    }
                    break;
                case 4:
                    String phoneNumberRegex = "^(0|\\+84)(?:(3|5|7|8|9)\\d{8}|2\\d{9})$";
                    if (Pattern.matches(phoneNumberRegex, phoneNumber)) {
                        System.out.println("Số điện thoại hợp lệ.");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ.");
                    }
                    break;
                case 5:
                    String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
                    if (Pattern.matches(passwordRegex, password)) {
                        System.out.println("Mật khẩu hợp lệ.");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ.");
                    }
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập trong khoảng từ 1 đến 6!");
            }

        } while (true);
    }

}