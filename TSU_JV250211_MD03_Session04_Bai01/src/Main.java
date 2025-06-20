import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        final int SIZE = scanner.nextInt();
        int [] array = new int[SIZE];

        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        selectionSort(array);

        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần:");
        System.out.print(Arrays.toString(array));
        System.out.println("\nPhần tử lớn nhất trong mảng là: " + array[0]);
        scanner.close();
    }
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }

}