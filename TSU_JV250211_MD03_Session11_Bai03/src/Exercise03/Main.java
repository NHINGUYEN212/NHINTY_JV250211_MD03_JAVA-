package Exercise03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Message> messages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("=========ỨNG DỤNG CHAT ĐƠN GIẢN==========");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem tất cả tin nhắn");
            System.out.println("3. Lọc theo người gửi");
            System.out.println("4. Lọc theo ngày");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        sendMessage();
                        break;
                    case 2:
                        showMessages();
                        break;
                    case 3:
                        filterBySender();
                        break;
                    case 4:
                        filterByDate();
                        break;
                    case 5:
                        System.out.println("Kết thúc chương trình");
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1-5");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số 1-5");
            }
        } while (true);
    }
    private static void sendMessage() {
        System.out.println("Nhập tên người gửi:");
        String sender = scanner.nextLine();
        System.out.println("Nhập nội dung tin nhắn:");
        String content = scanner.nextLine();
        Message message = new Message(sender, content, LocalDateTime.now());
        messages.add(message);
        System.out.println("Tin nhắn đã được gửi");
    }

    private static void showMessages() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào");
        } else  {
            messages.forEach(message -> System.out.println(message.display()));
        }
    }

    private static void filterBySender() {
        System.out.println("Nhập tên người gửi muốn lọc tin nhắn:");
        String sender = scanner.nextLine();
        List<Message> filteredMessages = messages.stream().filter(message -> message.getSender().equalsIgnoreCase(sender)).collect(Collectors.toList());
        if (filteredMessages.isEmpty()) {
            System.out.println("Không có tin nhắn nào từ người gửi: " + sender);
        } else   {
            filteredMessages.forEach(messages -> System.out.println(messages.display()));
        }
    }

    private static void filterByDate() {
        System.out.println("Nhập ngày muốn lọc tin nhắn (dd-MM-yyyy):");
        String date = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate localDate = LocalDate.parse(date, dtf);
            List<Message> filteredMessages = messages.stream().filter(message -> message.getTimestamp().toLocalDate().equals(localDate)).collect(Collectors.toList());
            if (filteredMessages.isEmpty()) {
                System.out.println("Không có tin nhắn nào trong ngày: " + date);
            } else   {
                filteredMessages.forEach(message -> System.out.println(message.display()));
            }

        } catch (Exception e) {
            System.err.println("Định dạng ngày không hợp lệ. Vui lòng nhập đúng định dạng dd-MM-yyyy");
        }
    }
}
