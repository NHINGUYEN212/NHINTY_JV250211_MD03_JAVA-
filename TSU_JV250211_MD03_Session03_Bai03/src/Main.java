import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int staffCount = 0;
        float totalSalary = 0;
        float maxSalary = Float.MIN_VALUE;
        float minSalary = Float.MAX_VALUE;
        float totalBonus = 0;

        do {
            System.out.println("***************MENU NHẬP LƯƠNG***************");
            System.out.println("1.  Nhập lương nhân viên");
            System.out.println("2.  Hiển thị thống kê");
            System.out.println("3.  Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("4.  Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        do {
                            System.out.println("--- Nhập lương của nhân viên (nhập -1 để kết thúc) --- ");
                            System.out.print("Nhập lương: ");
                            try {
                                float salary = Float.parseFloat(scanner.nextLine());
                                float bonus = 0;

                                if (salary == -1) {
                                    System.out.println("Kết thúc quá trình nhập lương.");
                                    break;
                                } else if (salary <= 0 || salary > 500000000) {
                                    System.err.println("Lỗi: Tiền lương không hợp lệ. Lương phải có giá trị từ 0 đến 500 triệu. Nhập lại!");
                                } else {
                                    staffCount++;
                                    totalSalary += salary;

                                    if (salary > maxSalary) {
                                        maxSalary = salary;
                                    }
                                    if (salary < minSalary) {
                                        minSalary = salary;
                                    }

                                    if (salary > 100000000) {
                                        bonus = salary * 0.25f;
                                        System.out.println("Thu nhập cao");
                                    } else if (salary > 50000000) {
                                        bonus = salary * 0.2f;
                                        System.out.println("Thu nhập cao");
                                    } else if (salary > 15000000) {
                                        bonus = salary * 0.15f;
                                        System.out.println("Thu nhập khá");
                                    } else if (salary > 5000000) {
                                        bonus = salary * 0.1f;
                                        System.out.println("Thu nhập trung bình");
                                    } else {
                                        bonus = salary * 0.05f;
                                        System.out.println("Thu nhập thấp");
                                    }

                                    totalBonus += bonus;
                                }
                            } catch (NumberFormatException e) {
                                System.err.println("Lỗi: Vui lòng nhập một con số hợp lệ cho lương.");
                            }
                        } while (true);
                        break;

                    case 2:
                        if (staffCount == 0) {
                            System.out.println("Chưa có dữ liệu.");
                        } else {
                            System.out.println("--- Thống kê ---");
                            System.out.println("Số nhân viên: " + staffCount);
                            System.out.printf("Tổng lương: %.2f VND%n", totalSalary);
                            System.out.printf("Lương trung bình: %.2f VND%n", totalSalary / staffCount);
                            System.out.printf("Lương cao nhất: %.2f VND%n", maxSalary);
                            System.out.printf("Lương thấp nhất: %.2f VND%n", minSalary);
                        }
                        break;
                    case 3:
                        System.out.println("--- Tính tổng tiền thưởng nhân viên ---");
                        System.out.printf("Tổng tiền thưởng nhân viên: %.2f VND%n", totalBonus);
                        break;
                    case 4:
                        System.out.println("Kết thúc chương trình.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Hãy nhập trong khoảng từ 1 đến 4");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Lựa chọn menu phải là một con số từ 1 đến 4.");
            }
        } while (true);
    }
}