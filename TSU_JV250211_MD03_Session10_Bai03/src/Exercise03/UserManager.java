package Exercise03;

import java.util.LinkedList;
import java.util.Scanner;

public class UserManager {
    private LinkedList<User> users;

    public UserManager() {
        users = new LinkedList<>();
    }

    public void addUser(Scanner scanner) {
        User newUser = new User();
        newUser.inputData(scanner);
        users.addFirst(newUser);
        System.out.println("Thêm người dùng thành công");

    }

    public void removeUser(Scanner scanner) {
        System.out.println("Nhập email người dùng muốn xoá:");
        String email = scanner.nextLine();
        boolean found = false;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                users.remove(user);
                System.out.println("Đã xoá thành công");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy người dùng muốn xoá");
        }
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("Danh sách người dùng trống");
        } else {
            for (User user : users) {
                user.displayData();
            }
        }
    }
}
