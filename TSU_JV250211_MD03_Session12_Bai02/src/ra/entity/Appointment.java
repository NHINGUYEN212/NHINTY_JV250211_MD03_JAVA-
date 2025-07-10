package ra.entity;

import ra.business.AppointmentBusiness;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {
    }

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void inputData(Scanner scanner) {
        this.appointmentId = inputAppointmentId(scanner);
        this.patientName = inputPatientName(scanner);
        this.phoneNumber = inputPhoneNumber(scanner);
        this.appointmentDate = inputAppointmentDate(scanner);
        this.doctor = inputDoctor(scanner);
    }

    public String inputAppointmentId(Scanner scanner) {
        System.out.println("Nhập vào mã lịch hẹn:");
        do {
            String appointmentId = scanner.nextLine();
            String appointmentIdRegex = "\\w{6}";
            if (appointmentId.matches(appointmentIdRegex)) {
                boolean isExit = AppointmentBusiness.appointmentsList.stream().anyMatch(ap -> ap.getAppointmentId().equals(appointmentId));
                if (isExit) {
                    System.err.println("Mã lịch hẹn đã tồn tại. Vui lòng nhập mã lịch hẹn khác!");
                } else {
                    return appointmentId;
                }
            } else {
                System.err.println("Mã lịch hẹn phải gồm 6 ký tự. Vui lòng nhập lạị!");
            }
        } while (true);
    }

    public String inputPatientName(Scanner scanner) {
        System.out.println("Nhập vào tên bệnh nhân:");
        do {
            String patientName = scanner.nextLine();
            if (patientName.length() >= 10 && patientName.length() <= 50) {
                return patientName;
            }
            System.err.println("Tên bệnh  phải có 10-50 ký tự. Vui lòng nhập lại!");
        } while (true);
    }

    public String inputPhoneNumber(Scanner scanner) {
        System.out.println("Nhập vào số điện thoại:");
        do {
            String phoneNumber = scanner.nextLine();
            String phoneNumberRegex = "^(0|\\+84)(?:(3|5|7|8|9)\\d{8}|2\\d{9})$";
            if (phoneNumber.matches(phoneNumberRegex)) {
                return phoneNumber;
            } else {
                System.err.println("SĐT không đúng định dạng. Vui lòng nhập lại!");
            }
        } while (true);
    }

    public LocalDate inputAppointmentDate(Scanner scanner) {
        System.out.println("Nhập vào ngày khám:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            String appointmentDate = scanner.nextLine();
            try {
                return LocalDate.parse(appointmentDate, formatter);

            } catch (DateTimeException e) {
                System.err.println("Ngày tháng không đúng định dạng. Vui lòng nhập lại!");
            }
        } while (true);
    }

    public String inputDoctor(Scanner scanner) {
        System.out.println("Nhập vào tên bác sĩ:");
        do {
            String doctor = scanner.nextLine();
            if (doctor.length() <= 200) {
                return doctor;
            } else {
                System.err.println("Tên bác sĩ tối đa có 200 ký tự. Vui lòng nhập lại!");
            }

        } while (true);
    }


    @Override
    public String toString() {
        return String.format("Mã khám bệnh: %s - Bệnh nhân: %s - SĐT: %s - Ngày khám: %s - Bác sĩ: %s\n", appointmentId, patientName, phoneNumber, appointmentDate, doctor);
    }
}
