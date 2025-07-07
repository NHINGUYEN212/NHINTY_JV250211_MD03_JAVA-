package ra.presentation;

import ra.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    static Student[] arrayStudents = new Student[100];
    static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***************QUẢN LÝ SINH VIÊN****************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm sinh viên theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayStudent();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    searchStudentByName(scanner);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }

    //    Chuc nang 1:
    public static void displayStudent() {
        for (int i = 0; i < currentIndex; i++) {
            arrayStudents[i].displayData();
        }
    }

    //    Chuc nang 2:
    public static void addStudent(Scanner scanner) {
        System.out.println("Nhập vào số lượng sinh viên cần nhập thông tin:");
        int cntStudent = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntStudent; i++) {
            arrayStudents[currentIndex] = new Student();
            arrayStudents[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }
//    Ham tim kiem index bang Id
    public static int findIndexById(String studentId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrayStudents[i].getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    //    Chuc nang 3:
    public static void updateStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật thông tin:");
        String studentId = scanner.nextLine();
        int indexUpdate = findIndexById(studentId);
        if (indexUpdate == -1) {
            System.err.println("Mã sinh viên không tồn tại!");
        } else {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sinh viên");
                System.out.println("2. Cập nhật tuổi sinh viên");
                System.out.println("3. Cập nhật chuyên ngành sinh viên");
                System.out.println("4. Thoát");
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên sinh viên mới:");
                        arrayStudents[indexUpdate].setStudentName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào tuổi mới của sinh viên:");
                        arrayStudents[indexUpdate].setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào chuyên ngành mới của sinh viên:");
                        arrayStudents[indexUpdate].setMajor(scanner.nextLine());
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-4");
                }

            } while (isExit);
        }
    }

    //    Chuc nang 4
    public static void deleteStudent(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần xóa:");
        String studentId = scanner.nextLine();
        int indexDelete = findIndexById(studentId);
        if (indexDelete == -1) {
            System.err.println("Mã sinh viên không tồn tại!");
        } else {
            for (int i = indexDelete; i < currentIndex - 1; i++) {
                arrayStudents[i] = arrayStudents[i + 1];
            }
            arrayStudents[currentIndex - 1] = null;
            currentIndex--;
        }
    }

    //    Chuc nang 5:
    public static void searchStudentByName(Scanner scanner) {
        int cntStudent = 0;
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String studentNameSearch = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (arrayStudents[i].getStudentName().toLowerCase().contains(studentNameSearch.toLowerCase())) {
                arrayStudents[i].displayData();
                cntStudent++;
            }
        }
        System.out.printf("Có %d sinh viên thỏa mãn điều kiện tìm kiếm%n", cntStudent);
    }

//
}




