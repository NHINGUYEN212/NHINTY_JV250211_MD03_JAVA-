import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> plates = new ArrayList<>();
        int choice;

        do {
            printMenu();
            System.out.print("Lựa chọn của bạn: ");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e){
                System.err.println("Lỗi. Lựa chọn phải là một số. Vui lòng nhập lại!");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    addPlate(scanner, plates);
                    break;
                case 2:
                    displayPlate(plates);
                    break;
                case 3:
                    exactSearch(scanner, plates);
                    break;
                case 4:
                    searchByProvince(scanner, plates);
                    break;
                case 5:
                    sortPlate(plates);
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.err.println("Lỗi. Lựa chọn không hợp lệ. Vui lòng nhập số trong khoảng từ 1 đến 6!");

            }

        } while (choice != 6);
    }

//    In menu:

    public static void printMenu() {
        System.out.println("******************QUẢN LÝ BIỂN SỐ XE****************");
        System.out.println("1. Thêm các biển số xe");
        System.out.println("2. Hiển thị danh sách biển số xe");
        System.out.println("3. Tìm kiếm biển số xe");
        System.out.println("4. Tìm biển số xe theo mã tỉnh");
        System.out.println("5. Sắp xếp biển số xe tăng dần");
        System.out.println("6. Thoát");
    }

//    Chức năng 1: Thêm các biển số xe

    public static void addPlate(Scanner scanner, ArrayList<String> plates) {
        final String PLATE_REGEX = "^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$";
        System.out.println("Nhập các biển số xe (định dạng XXY-XXX.XX, ví dụ: 30F-123.45):");
        System.out.println("Nhập 'xong' để kết thúc việc nhập biển số xe.");
            while (true) {
                System.out.print("Nhập biển số: ");
                String plate = scanner.nextLine().trim().toUpperCase();

                if (plate.equalsIgnoreCase("xong")) {
                    break;
                }

                if (Pattern.matches(PLATE_REGEX, plate)) {
                    if (!plates.contains(plate)) {
                        plates.add(plate);
                        System.out.println("Đã thêm thành công biển số: " + plate);
                    } else {
                        System.err.println("Lỗi. Biển số " + plate + " đã tồn  trong danh sách. Vui lòng nhập biển số khác!");

                    }
                } else {
                    System.err.println("Lỗi: Biển số nhập vào không đúng định dạng. Vui lòng nhập biển số xe theo định dạng XXY-XXX.XX, ví dụ: 30F-123.45!");
                }
            }

    }

//    Chức năng 2: Hiển thị danh sách biển số xe

    public static void displayPlate(ArrayList<String> plates) {
        System.out.println("--- DANH SÁCH BIỂN SỐ XE ---");
        if (plates.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (int i = 0; i < plates.size(); i++) {
            System.out.println("Biển số thứ " + (i + 1) + ": " + plates.get(i));
        }
    }

//    Chức năng 3: Tìm kiếm biển số xe

    public static void exactSearch(Scanner scanner, ArrayList<String> plates) {
        if (plates.isEmpty()) {
            System.out.println("Danh sách trống. Không thể tìm kiếm.");
            return;
        }
        System.out.print("Nhập chính xác biển số xe cần tìm: ");
        String searchPlate = scanner.nextLine().trim().toUpperCase();
        boolean found = false;
        for (int i = 0; i < plates.size(); i++) {
            if (plates.get(i).equalsIgnoreCase(searchPlate)) {
                System.out.println("Tìm thấy biển số xe: " + plates.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy biển số xe:  " + searchPlate);
        }
    }

//    Chức năng 4: Tìm biển số xe theo mã tỉnh

    public static void searchByProvince(Scanner scanner, ArrayList<String> plates) {
        if (plates.isEmpty()) {
            System.out.println("Danh sách trống. Không thể tìm kiếm.");
            return;
        }
        System.out.print("Nhập mã tỉnh cần tìm kiếm (ví dụ: 29, 16, 51): ");
        String provinceCode = scanner.nextLine().trim();
        ArrayList<String> platesSearchByProvinceCode = new ArrayList<>();

        for (String plate : plates) {
            if (plate.startsWith(provinceCode)) {
                platesSearchByProvinceCode.add(plate);
            }
        }
        if (platesSearchByProvinceCode.isEmpty()) {
            System.out.println("Không tìm thấy biển số nào có mã tỉnh: " + provinceCode);
        } else {
            System.out.println("--- Các biển số xe có mã tình " + provinceCode + "---");
            for (int i = 0; i < platesSearchByProvinceCode.size(); i++) {
                System.out.println("Biển số thứ " + (i + 1) + ": " + platesSearchByProvinceCode.get(i));
            }
        }

    }

//    Chức năng 5: Sắp xếp biển số xe tăng dần

    public static void sortPlate(ArrayList<String> plates) {
        if (plates.isEmpty()) {
            System.out.println("Danh sách trống. Không thể sắp xếp.");
            return;
        }
        for (int i = 0; i < plates.size(); i++) {
            for (int j = i + 1; j < plates.size(); j++) {
                if (plates.get(i).compareToIgnoreCase(plates.get(j)) > 0) {
                    String temp = plates.get(i);
                    plates.set(i, plates.get(j));
                    plates.set(j, temp);
                }
            }
        }
        System.out.println("Danh sách biển số sau khi sắp xếp theo thứ tự tăng dần:");
        for (int i = 0; i < plates.size(); i++) {
            System.out.println(plates.get(i));
        }
    }
}