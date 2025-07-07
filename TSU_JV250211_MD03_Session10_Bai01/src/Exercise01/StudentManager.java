package Exercise01;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private final ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Scanner scanner) {
        Student student = new Student();
        student.inputData(scanner);
        students.add(student);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        for (Student student : students) {
            student.displayData();
        }
    }
}
