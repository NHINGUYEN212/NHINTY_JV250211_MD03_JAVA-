//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        String string = "Hello";
        startTime =System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            string += " World";
        }
        endTime =System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với String: " + (endTime - startTime) + "ms");


        StringBuilder stringBuilder = new StringBuilder("Hello");
        startTime =System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append(" World");
        }
        endTime =System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder: " + (endTime - startTime) + "ms");

        StringBuffer stringBuffer = new StringBuffer("Hello");
        startTime =System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append(" World");
        }
        endTime =System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer: " + (endTime - startTime) + "ms");

        System.out.println("Nhận xét:");
        System.out.println("- String: Không hiệu quả do cho phép nối chuỗi nhiều lần tạo ra nhiều đối tượng mới.");
        System.out.println("- StringBuilder: Hiệu quả và nhanh chóng,  thích hợp cho nhiều thao tác nối chuỗi trong một luồng.");
        System.out.println("- StringBuffer: Tương tự như StringBuilder nhưng an toàn với đa luồng, có thể chậm hơn một chút do đồng bộ hóa.");
    }
}