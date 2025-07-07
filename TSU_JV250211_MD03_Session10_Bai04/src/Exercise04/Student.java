package Exercise04;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayData() {
        System.out.printf("ID: %d, tên SV: %s%n", id, name);
    }

    private int inputId(Scanner scanner) {
        String input = "";
        int inputId;
        while (true) {
            System.out.println("Nhập ID cho sinh viên: ");
            input = scanner.nextLine();
            try {
                inputId = Integer.parseInt(input);
                if (input.isEmpty()) {
                    System.err.println("ID khôgn được để trống");
                } else if (inputId < 0) {
                    System.err.println("Vui lòng nhập số nguyên >= 0");
                } else {
                    return inputId;
                }

            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên >= 0");
            }
        }
    }

    private String inputName(Scanner scanner) {
        String inputName = "";
        do {
            System.out.println("Nhập tên sinh viên:");
            inputName = scanner.nextLine();
            if (inputName.isEmpty()) {
                System.err.println("Tên khôgn được để trống");
            } else  {
                break;
            }

        } while (inputName.isEmpty());
        return inputName;
    }

    public void inputData(Scanner scanner) {
        this.name = inputName(scanner);
        this.id = inputId(scanner);
    }
}
