package Exercise04;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceManager implements Manager<Student> {
    public ArrayList<Student> students;
    public AttendanceManager() {
        students = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(int index, Student student) {
        if (index >= 0 && index < students.size()) {
            students.set(index, student);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < students.size()) {
            students.remove(index);
        }
    }
    @Override
    public void display() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
        } else {
            for (int i = 0; i < students.size(); i++) {
                students.get(i).displayData();
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void updateStudentById(Scanner scanner) {
        System.out.println("Nhập mã sinh viên cần sửa:");
        int updateId = Integer.parseInt(scanner.nextLine());
        int updateIndex = findIndexById(updateId);
        if (updateIndex == -1) {
            System.out.println("Không tìm thấy sinh viên cần sửa");
        } else {
            System.out.println("Nhập tên mới:");
            String updateName = scanner.nextLine();
            students.get(updateIndex).setName(updateName);
            System.out.println("Sinh viên đã được sửa thành công");
        }
    }

    public void deleteStudentById(Scanner scanner) {
        System.out.println("Nhập mã sinh viên cần xoá:");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int deleteIndex = findIndexById(deleteId);
        if (deleteIndex == -1) {
            System.out.println("Không tìm thấy sinh viên cần xoá");
        } else {
            students.remove(deleteIndex);
            System.out.println("Đã xoá thành công sinh viên");
        }

    }
}
