import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Các số chẵn trong danh sách:");
        numbers.forEach(number -> {
            if(number % 2 == 0) {
                System.out.println(number);
            }
        });

        int sum = numbers.stream().mapToInt(number -> number).sum();
        System.out.printf("Tổng của tất cả các số trong danh sách: %d%n", sum);
    }
}