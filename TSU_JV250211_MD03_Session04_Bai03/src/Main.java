import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public  static  void bubbleSort(int[] arr){
        int n = arr.length;
        boolean flag = true;
        for(int i=0;i<n-1;i++){
            flag = false;
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng: ");
        final int SIZE = scanner.nextInt();
        System.out.println("Nhập các phần tử cho mảng:");
        int [] array = new int[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        bubbleSort(array);
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần là: ");
        System.out.print(Arrays.toString(array));
    }
}