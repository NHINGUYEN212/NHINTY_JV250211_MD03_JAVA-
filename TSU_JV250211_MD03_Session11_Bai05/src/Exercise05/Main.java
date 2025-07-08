package Exercise05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Event> events = new ArrayList<>();
    public void addEvent(String name, LocalDateTime startTime, LocalDateTime endTime) {
        Event event = new Event(name, startTime, endTime);
        events.add(event);
    }
    public void displayEvents() {
        System.out.println("Danh sách sự kiện:");
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main eventManager    = new Main();
        while (true) {
            System.out.println("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            String inputName = scanner.nextLine();
             if (inputName.equals("exit")) {
                 break;
             } else {
                 LocalDateTime startTime = inputTime(scanner, "Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm)");
                 LocalDateTime endTime = inputTime(scanner, "Nhập thời gian kết thúc (dd-MM-yyyy HH:mm)");
                 eventManager.addEvent(inputName, startTime, endTime);
             }
        }
        eventManager.displayEvents();
    }

    public static LocalDateTime inputTime(Scanner scanner, String message) {
        while (true) {
            try{
                System.out.println(message);
                String inputTime = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                return LocalDateTime.parse(inputTime, formatter);
            } catch(Exception e) {
                System.err.println("Lỗi định dạng. Vui lòng  đúng theo định dạng dd-MM-yyyy HH:mm");
            }
        }
    }
}
