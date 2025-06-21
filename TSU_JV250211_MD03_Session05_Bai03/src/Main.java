import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String string = scanner.nextLine();
        String replacedString = string.replaceAll("[0-9]", "*");
        System.out.print("Chuỗi sau khi thay thế: " + replacedString);
        scanner.close();
    }
}