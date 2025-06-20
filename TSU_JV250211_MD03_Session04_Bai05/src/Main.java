import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng: ");
        final int ROWS = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        final int COLS = scanner.nextInt();
        scanner.nextLine();
        int [][] arr = new int[ROWS][COLS];
        System.out.println("Nhập các phần tử cho mảng (theo từng hàng):");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("Hàng " +  (i + 1) + ": " );
            String line = scanner.nextLine();
            String [] values =  line.split(" ");
            for (int j = 0; j < COLS; j++) {
                arr[i][j] = Integer.parseInt(values[j]);
            }

        }
        int evenOfSum = 0;
        int oddOfSum = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (arr[i][j] % 2 == 0) {
                    evenOfSum += arr[i][j];
                }  else {
                    oddOfSum += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn là: " + evenOfSum);
        System.out.println("Tổng các số lẻ là: " + oddOfSum);
        scanner.close();
    }
}