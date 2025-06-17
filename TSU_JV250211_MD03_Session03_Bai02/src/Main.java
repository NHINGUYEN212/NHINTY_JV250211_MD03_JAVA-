import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = 0;
        float totalScore = 0;
        float maxScore = Float.MIN_VALUE;
        float minScore = Float.MAX_VALUE;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    do {
                        System.out.println("--- Nhập điểm học viên (Nhập -1 để dừng) ---");
                        float score = Float.parseFloat(scanner.nextLine());
                        if (score == -1) {
                            break;
                        } else if (score < 0 || score > 10) {
                            System.out.println("Điểm nhập không hợp lệ. Hãy nhập điểm trong khoảng từ 0 đến 10");
                        } else {
                            studentsCount++;
                            totalScore += score;
                            if (maxScore < score) {
                                maxScore = score;
                            }
                            if (minScore > score) {
                                minScore = score;
                            }
                            if (score < 5) {
                                System.out.println("Học lực: Yếu");
                            } else if (score < 7) {
                                System.out.println("Học lực: Trung Bình");
                            } else if (score < 8) {
                                System.out.println("Học lực: Khá");
                            } else if (score < 9) {
                                System.out.println("Học lực: Giỏi");
                            } else {
                                System.out.println("Học lực: Xuất sắc");
                            }
                        }
                    } while (true);
                    break;
                case 2:
                    System.out.println("--- KẾT QUẢ ---");
                    if (studentsCount == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        System.out.println("Số học viên đã nhập: " + studentsCount);
                        System.out.println("Điểm trung bình: " + totalScore / studentsCount);
                        System.out.println("Điểm cao nhất: " + maxScore);
                        System.out.println("Điểm thấp nhất : " + minScore);
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình .");
                    System.exit(0);
                    break;
            }
        } while (true);

    }
}