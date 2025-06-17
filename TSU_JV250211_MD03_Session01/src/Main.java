import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        session01-1
        System.out.println("Hello, Java!");

//        session01-2
        String name = "Nguyễn Thị Yến Nhi";
        int age = 30;
        String address = "Vĩnh Long";
        System.out.printf("Tên tôi là %s, tôi %d tuổi, hiện tại đang học tại PTIT-HCM. Quê ở %s.%n", name, age, address);

//        session01-3
        double radius;
        double area;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập bán kính của hình tròn: ");
        radius = scanner.nextDouble();

        area = Math.PI * Math.pow(radius, 2);
        System.out.printf("Diện tích hình tròn có bán kính %.2f là %.2f%n", radius, area);

//        session01-4
        int a = 50;
        int b = 5;

        int sum = a + b;
        int subtraction = a - b;
        int multiplication = a * b;
        int division = a / b;
        int modulo = a % b;

        System.out.printf("a = %d và b = %d%n", a, b);
        System.out.printf("Tổng 2 số a + b = %d%n", sum);
        System.out.printf("Hiệu 2 số a v- b = %d%n", subtraction);
        System.out.printf("Tích 2 số a * b = %d%n", multiplication);
        System.out.printf("Thương của a / b = %d%n", division);
        System.out.printf("Số dư khi chia số a cho b = %d%n", modulo);

//        session01-5
        System.out.print("Nhập tử số của phân số thứ nhất: ");
        int tuSo1 = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số thứ nhất: ");
        int mauSo1 = scanner.nextInt();

        System.out.print("Nhập tử số của phân số thứ hai: ");
        int tuSo2 = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số thứ hai: ");
        int mauSo2 = scanner.nextInt();

        int tuSoPhepTinhTong = tuSo1 * mauSo2 + tuSo2 * mauSo1;
        int mauSoPhepTinhTong = mauSo1 * mauSo2;
        System.out.println("Tổng hai phân số là: " + tuSoPhepTinhTong + "/" + mauSoPhepTinhTong);

//        session01-6
        float weight;
        float height;
        float circumference;
        float rectangleArea;

        System.out.print("Nhập chiểu rộng hình chữ nhật: ");
        weight = scanner.nextFloat();
        System.out.print("Nhập chiểu dài hình chữ nhật: ");
        height = scanner.nextFloat();
        circumference = (weight + height) * 2;
        rectangleArea = weight * height;
        System.out.printf("Chu vi hình chữ nhật là: %.2f%n", circumference);
        System.out.printf("Diện tích hình chữ nhật là: %.2f%n", rectangleArea);
        scanner.close();
    }
}