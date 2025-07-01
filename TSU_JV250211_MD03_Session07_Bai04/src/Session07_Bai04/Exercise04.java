package Session07_Bai04;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new Student("Alice", 20, "A1", 8.5);
        students[1] = new Student("Bob", 21, "A1", 7.0);
        students[2] = new Student("Charlie", 19, "A2", 9.0);
        students[3] = new Student("David", 22, "A2", 6.5);
        students[4] = new Student("Eve", 20, "A1", 8.0);

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm min: ");
        double min = sc.nextDouble();
        System.out.print("Nhập điểm max: ");
        double max = sc.nextDouble();
        System.out.println("Danh sách sinh viên có điểm trung bình từ " + min + " đến " + max + ":");
        for (Student student : students) {
            if (student.getAvgScore() >= min && student.getAvgScore() <= max) {
                System.out.println(student);
            }
        }
        sc.close();
    }

}
