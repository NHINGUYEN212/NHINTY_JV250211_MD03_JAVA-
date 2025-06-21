import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi văn bản: ");
        String text = scanner.nextLine().trim();
        System.out.print("Nhập từ cần tìm: ");
        String searchWord = scanner.nextLine().trim();

        int indexOfSearchWord = text.indexOf(searchWord);
        if (indexOfSearchWord == -1) {
            System.out.printf("Không tìm thấy từ %s trong chuỗi.%n", searchWord);
        }
        else {
            System.out.printf("Từ %s xuất  tại vị trí %d trong chuỗi.%n", searchWord, indexOfSearchWord);
        }
        scanner.close();
    }
}