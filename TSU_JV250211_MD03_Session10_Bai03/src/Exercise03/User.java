package Exercise03;

import java.util.Scanner;

public class User {
    private String userName;
    private String email;
    private String phoneNumber;

    public User() {
    }

    public User(String userName, String email, String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void displayData() {
        System.out.printf("Tên: %s, Email: %s, Số điện thoại: %s%n", userName, email, phoneNumber);
    }

    private String inputUserName(Scanner scanner) {
        String userName = "";
        do {
            System.out.println("Nhập tên người dùng:");
            userName = scanner.nextLine();
            if (userName.isEmpty()) {
                System.err.println("Không được để trống");
            }

        } while (userName.isEmpty());
        return userName;
    }

    private String inputEmail(Scanner scanner) {
        String email = "";
        do {
            System.out.println("Nhập email người dùng:");
            email = scanner.nextLine();
            if (email.isEmpty()) {
                System.err.println("Không được để trống");
            }
        } while (email.isEmpty());
        return email;
    }

    private String inputPhone(Scanner scanner) {
        String phoneNumber = "";
        do {
            System.out.println("Nhập số điện thoại người dùng:");
            phoneNumber = scanner.nextLine();
            try {
                if (phoneNumber.isEmpty()) {
                    System.err.println("Không được bỏ trống");
                }
                if (Double.parseDouble(phoneNumber.trim()) <= 0) {
                    System.err.println("Định dạng không chính xác. Vui lòng nhập lại.");
                    continue;
                }
                return phoneNumber;

            } catch (NumberFormatException e) {
                System.err.println("Định dạng số điện thoại không chính xác. Vui lòng nhập lại.");
            }

        } while (true);
    }

    public void inputData(Scanner scanner) {
        userName = inputUserName(scanner);
        email = inputEmail(scanner);
        phoneNumber = inputPhone(scanner);
    }
}
