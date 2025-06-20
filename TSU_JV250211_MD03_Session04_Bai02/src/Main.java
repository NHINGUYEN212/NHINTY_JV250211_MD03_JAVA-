import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        final int SIZE = scanner.nextInt();
        int [] arr = new int[SIZE];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < SIZE; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            sum += arr[i];
        }
        System.out.println("Tổng các phần tử trong mảng là: " + sum);
    }
}