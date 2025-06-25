import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>();
        int choice;

        do {
            printMenu();
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lựa chọn không hợp lệ. Vui lòng nhập một số!");
                choice = -1;
                continue;
            }
            switch (choice) {
                case 1:
                    inputScores(scanner, scores);
                    break;
                case 2:
                    printScores(scores);
                    break;
                case 3:
                    calculateAverage(scores);
                    break;
                case 4:
                    findMinMaxScore(scores);
                    break;
                case 5:
                    countPassFailStudents(scores);
                    break;
                case 6:
                    sortScores(scores);
                    break;
                case 7:
                    countExcellentStudents(scores);
                    break;
                case 8:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số trong khoảng từ 1 đến 8!");
            }

        } while (choice != 8);
        scanner.close();
    }
    public static void printMenu() {
        System.out.println("******************QUẢN LÝ ĐIỂM SV****************");
        System.out.println("1. Nhập danh sách điểm sinh viên");
        System.out.println("2. In danh sách điểm");
        System.out.println("3. Tính điểm trung bình của các sinh viên");
        System.out.println("4. Tìm điểm cao nhất và thấp nhất");
        System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
        System.out.println("6. Sắp xếp điểm tăng dần");
        System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
        System.out.println("8. Thoát");
    }
//    Chức năng 1: Nhập điểm
    public static void inputScores(Scanner scanner, ArrayList<Double> scores) {
        scores.clear();
        System.out.print("Bạn muốn nhập điểm cho bao nhiêu sinh viên: ");
        int count;
        try {
            count = Integer.parseInt(scanner.nextLine());
            if (count <= 0) {
                System.err.println("Số lượng sinh viên phải là số nguyên dương.");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Vui lòng nhập một số nguyên dương!");
            return;
        }
        System.out.println("Nhập điểm cho từng sinh viên:");
        for (int i = 0; i < count; i++) {
            while (true) {
                try {
                    System.out.print("Điểm của sinh viên " + (i + 1) + ": ");
                    double score = Double.parseDouble(scanner.nextLine());
                    if (score < 0 || score > 10) {
                        System.err.println("Điểm không hợp lệ. Vui lòng nhập điểm trong khoảng từ 0 đến 10!");
                    } else {
                        scores.add(score);
                        break;
                    }
                }  catch (NumberFormatException e) {
                    System.err.println("Dữ liệu không phải là số. Vui lòng nhập điểm là số hợp lệ!");
                }
            }
        }
        System.out.println("Đã nhập xong danh sách điểm sinh viên.");
    }

//    Chức năng 2: In danh sách điểm:

    public static void printScores(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        } else  {
            System.out.println("--- Danh sách điểm sinh viên ---");
            for (int i = 0; i < scores.size(); i++) {
                System.out.println("Sinh viên thứ " + (i + 1) + ": " + scores.get(i));
            }
        }
    }

//    Chức năng 3: Tính điểm trung bình:

    public static void calculateAverage(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            System.out.println("Danh sách trống. Không thể tính điểm trung bình.");
            return;
        }
        double sum = 0;
        for (Double score : scores) {
            sum += score;
        }
        double avg = sum / scores.size();
        System.out.printf("Điểm trung bình của %d sinh viên là: %.2f%n", scores.size(), avg);
    }
//    Chức năng 4: Tìm điểm thấp nhất và cao nhất:

    public static void findMinMaxScore(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        double minScore = Double.MAX_VALUE;
        double maxScore = Double.MIN_VALUE;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) < minScore) {
                minScore = scores.get(i);
            }
            if (scores.get(i) > maxScore) {
                maxScore = scores.get(i);
            }
        }
        System.out.println("Điểm cao nhất là: " + maxScore);
        System.out.println("Điểm thấp nhất là: " + minScore);
    }

//    Chức năng 5: Đếm số lượng sinh viên đỗ và trượt:

    public static void countPassFailStudents(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        int passCount = 0;
        int failCount = 0;
        for (double score: scores) {
            if (score >= 5) {
                passCount++;
            } else {
                failCount++;
            }
        }
        System.out.println("Số lượng sinh viên đạt: " + passCount);
        System.out.println("Số lượng sinh viên trượt: " + failCount);
    }

//    Chức năng 6: Sắp xếp điểm tăng dần:

    public static void sortScores(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("Danh sách điểm sinh viên sắp xếp tăng dần:");
        for (int i = 0; i < scores.size() - 1; i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(i) > scores.get(j)) {
                    double temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        for (int i = 0; i < scores.size(); i++) {
            System.out.printf("%.2f%n", scores.get(i));
        }
    }

//    Chức năng 7: Thống kê số lượng sinh viên giỏi và xuất sắc:

    public static void countExcellentStudents(ArrayList<Double> scores) {
        if (scores.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        int excellentCount = 0;
        for (double score: scores) {
            if (score >= 8) {
                excellentCount++;
            }
        }
        System.out.println("Số lượng sinh viên giỏi và xuất sắc là: " + excellentCount);
    }
}