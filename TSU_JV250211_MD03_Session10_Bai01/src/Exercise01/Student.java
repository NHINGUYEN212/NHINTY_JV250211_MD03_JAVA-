package Exercise01;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private double averageScore;

    public Student() {
    }

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public void displayData() {
        System.out.printf("Name: %s, Age: %d, Average: %.2f%n", name, age, averageScore);
    }

    private String inputName(Scanner scanner) {
        String inputName = "";
        do {
            System.out.println("Nhập tên sinh viên:");
            inputName = scanner.nextLine();
            if (inputName.isEmpty()) {
                System.out.println("Vui lòng không để trống");
            }

        } while (inputName.isEmpty());
        return inputName;
    }

    private int inputAge(Scanner scanner) {
        String inputAge = "";
        do {
            System.out.println("Nhập tuổi sinh viên:");
            inputAge = scanner.nextLine();
            try {
                if (inputAge.isEmpty()) {
                    System.out.println("Vui lòng không để trống");
                } else if (Integer.parseInt(inputAge) < 0) {
                    System.out.println("vui lòng nhập số nguyên >= 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên >= 0");
            }

        } while (inputAge.isEmpty());
        return Integer.parseInt(inputAge);
    }

    private double inputAverageScore(Scanner scanner) {
        String inputAverageScore = "";
        do {
            System.out.println("Nhập điểm trung bình của sinh viên:");
            inputAverageScore = scanner.nextLine();
            try {
                if (inputAverageScore.isEmpty()) {
                    System.out.println("Vui lòng không để trống");
                } else if (Double.parseDouble(inputAverageScore) < 0) {
                    System.out.println("vui lòng nhập số thực >= 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực >= 0");
            }

        } while (inputAverageScore.isEmpty());
        return Double.parseDouble(inputAverageScore);
    }

    public void inputData(Scanner scanner) {
        this.name = inputName(scanner);
        this.age = inputAge(scanner);
        this.averageScore = inputAverageScore(scanner);
    }
}
