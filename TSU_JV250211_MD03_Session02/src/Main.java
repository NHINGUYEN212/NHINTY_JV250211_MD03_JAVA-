import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //session02-1 Kiểm tra số chẵn, lẻ
        System.out.print("Nhập một số nguyên: ");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        } else if (n % 2 == 0) {
            System.out.printf("Số %d là số chẵn.%n", n);
        } else {
            System.out.printf("Số %d là số lẻ.%n", n);
        }

        //session02-2 Chọn ngày trong tuần
        System.out.print("Nhập một số nguyên từ 1 đến 7: ");
        int day = scanner.nextInt();

        switch (day) {
            case 1:
                System.out.println("Chủ Nhật");
                break;
            case 2:
                System.out.println("Thứ hai");
                break;
            case 3:
                System.out.println("Thứ ba");
                break;
            case 4:
                System.out.println("Thứ tư");
                break;
            case 5:
                System.out.println("Thứ năm");
                break;
            case 6:
                System.out.println("Thứ sáu");
                break;
            case 7:
                System.out.println("Thứ bảy");
                break;
            default:
                System.err.println("Số nhập vào không hợp lệ");
                scanner.next();
                break;
        }
        //session02-3 Tính tổng các số từ 1 đến N
        System.out.print("Nhập một số nguyên dương N: ");
        int N = scanner.nextInt();
        if (N <= 0) {
            System.err.println("Số nhập vào không hợp lệ");
            scanner.next();
        } else {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            System.out.printf("Tổng các số từ 1 đến %d là %d.%n", N, sum);
        }
        //session02-4
        int age = 1;
        do {
            System.out.print("Vui lòng nhập số tuổi của bạn: ");

            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age > 0) {
                    System.out.printf("Tuổi của bạn là: %d.%n", age);
                } else {
                    System.err.println(" Vui lòng nhập vào một số nguyên  và lớn hơn 0");
                }
            } else {
                System.err.println(" Vui lòng nhập vào một số nguyên  và lớn hơn 0");
                scanner.next();
            }
        } while (age <= 0);

        //session02-5 Tìm số ngày trong tháng
        System.out.print("Nhập một số nguyên từ 1 đến 12: ");
        int month = scanner.nextInt();
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.printf("Tháng %d có 31 ngày.%n", month);
                break;
            case 4, 6, 9, 11:
                System.out.printf("Tháng %d có 30 ngày.%n", month);
                break;
            case 2:
                System.out.printf("Tháng %d có 28 hoặc 29 ngày.%n", month);
                break;
            default:
                System.err.println("Tháng không hợp lệ.");
                scanner.next();
        }
        //session02-6 Tính tổng các chữ số của môt số nguyên
        System.out.print("Nhập một số nguyên bất kỳ: ");
        int number = Math.abs(scanner.nextInt());
        int digit, sum = 0;
        while (number > 0) {
            digit = number % 10;
            sum += digit;
            number /= 10;

        }
        System.out.printf("Tổng các chữ số là: %d.%n", sum);
    }
}