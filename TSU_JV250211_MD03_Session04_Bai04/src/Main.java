import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        final int SIZE = scanner.nextInt();
        if (SIZE <= 0) {
            System.out.println("Kích thước rỗng.");
            return;
        } else {
            System.out.println("Nhập các phần tử của mảng:");
            int[] arr = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                arr[i] = scanner.nextInt();

            }
            System.out.println("Mảng ban đầu là: ");
            System.out.println(Arrays.toString(arr));

            for (int i = 0; i < SIZE / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[SIZE - 1 - i];
                arr[SIZE - 1 - i] = temp;
            }

            System.out.println("Mảng sau khi đảo ngược là: ");
            System.out.println(Arrays.toString(arr));
            scanner.close();
        }


    }
}