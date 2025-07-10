package ra.business;

import ra.entity.Appointment;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    public static List<Appointment> appointmentsList = new ArrayList<Appointment>();

    public static void addAppointment(Scanner scanner) {
        Appointment appointment = new Appointment();
        appointment.inputData(scanner);
        appointmentsList.add(appointment);
    }

    public static void displayAppointments(Scanner scanner) {
        appointmentsList.stream().sorted(Comparator.comparing(Appointment::getAppointmentDate)).forEach(System.out::println);
    }

    public static void searchAppointmentsByPatientName(Scanner scanner) {
        System.out.println("Nhập vào tên bệnh nhân cần tìm:");
        String patientName = scanner.nextLine();
        List<Appointment> list = appointmentsList.stream().filter(appointment -> appointment.getPatientName().toLowerCase().contains(patientName.toLowerCase())).toList();
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy lịch hẹn của bệnh nhân: " + patientName);
        } else {
            list.forEach(System.out::println);
        }
    }

    public static void updateAppointment(Scanner scanner) {
        System.out.println("Nhập vào mã lịch hẹn cần cập nhật:");
        String updateAppointmentId = scanner.nextLine();
        Optional<Appointment> appointment = appointmentsList.stream().filter(app -> app.getAppointmentId().equals(updateAppointmentId)).findFirst();
        appointment.ifPresentOrElse(app -> {
            boolean isExit = true;
            do {
                System.out.println("============CẬP NHẬT LỊCH HẸN=============");
                System.out.println("1. Cập nhật tên bệnh nhân");
                System.out.println("2. Cập nhật số điện thoại");
                System.out.println("3. Cập nhật ngày khám");
                System.out.println("4. Cập nhật bác sĩ");
                System.out.println("5. Thoát");
                System.out.print("Lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên bệnh nhân mới:");
                        app.setPatientName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào số điện thoại mới:");
                        app.setPhoneNumber(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào ngày khám mới:");
                        app.setAppointmentDate(LocalDate.parse(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Nhập vào tên bác sĩ mới:");
                        app.setDoctor(scanner.nextLine());
                        break;
                    case 5:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-5");
                }
            } while (isExit);
        }, () -> {
            System.err.println("Mã lịch khám không tồn tại.");
        });
    }

    public static void deleteAppointment(Scanner scanner) {
        System.out.println("Nhập vào mã lịch khám cần xoá:");
        String deleteAppointmentId = scanner.nextLine();
        appointmentsList.stream().filter(app -> app.getAppointmentId().equals(deleteAppointmentId)).findFirst().ifPresentOrElse(app -> {
            System.out.println("Bạn có thật sự muốn xoá  (Y/N) ?");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                appointmentsList.remove(app);
                System.out.println("Đã xoá lịch hẹn");
            } else {
                System.out.println("Huỷ xoá lịch hẹn");
            }
        }, () -> {
            System.err.println("Mã lịch khám không tồn tại.");
        });
    }

    public static void statisticSumAppointments(Scanner scanner) {
        long cntAppointments = appointmentsList.stream().count();
        System.out.println("Tổng số lịch khám: " + cntAppointments);
    }

    public static void statisticSumAppointmentsByDoctor(Scanner scanner) {
        Map<String, Long> appointmentsByDoctor = appointmentsList.stream().collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));
        for (Map.Entry<String, Long> entry : appointmentsByDoctor.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


}
