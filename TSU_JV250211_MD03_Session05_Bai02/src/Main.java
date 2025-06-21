//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    StringBuilder orginalString = new StringBuilder("Hello, Java World!");
    System.out.println("Chuỗi ban đầu: " + orginalString);
    orginalString.delete(5, 11);
    System.out.println("Chuỗi sau khi xoá: " + orginalString);
    int start = orginalString.indexOf("World");
    int end = start + "World".length();
    if (start != -1 && end != -1) {
        orginalString.replace(start, end, "Universe");
    }
    System.out.println("Chuỗi sau khi thay thế: "+ orginalString);

    }
}