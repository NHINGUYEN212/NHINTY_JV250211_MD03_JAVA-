import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhâp kích thước mảng: ");
        final int SIZE = scanner.nextInt();
        int [] arr = new int[SIZE];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < SIZE; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Nhập số cần tìm: ");
        int searchNumber = scanner.nextInt();

        selectionSort(arr);
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần: ");
        System.out.println(Arrays.toString(arr));

        int searchIndexByBinary = binarySearch(arr, searchNumber);
        int searchIndexBySequential = sequentialSearch(arr, searchNumber);

        if (searchIndexByBinary == -1) {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy");
        } else {
            System.out.printf("Tìm kiếm nhị phân: Phần tử %d tìm thấy tại chỉ số: %d.%n", searchNumber, searchIndexByBinary);
        }
        if (searchIndexBySequential == -1) {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy");
        } else {
            System.out.printf("Tìm kiếm tuyến tính: Phần tử %d tìm thấy tại chỉ số: %d.%n", searchNumber, searchIndexBySequential);
        }

        scanner.close();
    }
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static int binarySearch(int[] arr, int searchNumber) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == searchNumber) {
                return mid;
            }
            if (arr[mid] < searchNumber) {
                high = mid - 1;
            } else  {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static int sequentialSearch(int[] arr, int searchNumber) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchNumber) {
                return i;
            }
        }
        return -1;
    }
}