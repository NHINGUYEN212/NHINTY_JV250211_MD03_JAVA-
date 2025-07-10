package ra.entity;

import ra.business.AppointmentBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=============QUẢN LÝ LỊCH HẸN============");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã lịch hẹn");
            System.out.println("5. Xóa lịch hẹn theo mã lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    AppointmentBusiness.addAppointment(scanner);
                    break;
                case 2:
                    AppointmentBusiness.displayAppointments(scanner);
                    break;
                case 3:
                    AppointmentBusiness.searchAppointmentsByPatientName(scanner);
                    break;
                case 4:
                    AppointmentBusiness.updateAppointment(scanner);
                    break;
                case 5:
                    AppointmentBusiness.deleteAppointment(scanner);
                    break;
                case 6:
                    displayStatistics(scanner);
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-7");
            }

        } while (true);
    }

    public static void displayStatistics(Scanner scanner) {
        boolean isRunning = true;
        do {
            System.out.println("=========THỐNG KÊ========");
            System.out.println("1. Tổng số lịch hẹn");
            System.out.println("2. Thống kê theo từng bác sĩ");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    AppointmentBusiness.statisticSumAppointments(scanner);
                    break;
                case 2:
                    AppointmentBusiness.statisticSumAppointmentsByDoctor(scanner);
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-3");
            }

        } while (isRunning);
    }

}
