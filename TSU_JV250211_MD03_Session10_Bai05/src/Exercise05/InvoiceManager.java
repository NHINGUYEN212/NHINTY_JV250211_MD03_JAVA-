package Exercise05;

import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceManager implements Manage<Invoice> {
    public ArrayList<Invoice> invoices;

    public InvoiceManager() {
        invoices = new ArrayList<>();
    }

    @Override
    public void add(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public void update(int index, Invoice invoice) {
        if (index >= 0 && index < invoices.size()) {
            invoices.set(index, invoice);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < invoices.size()) {
            invoices.remove(index);
        }
    }

    @Override
    public void display() {
        if (invoices.isEmpty()) {
            System.out.println("Danh sách hoá đơn trống");
        } else {
            for (int i = 0; i < invoices.size(); i++) {
                invoices.get(i).displayData();
            }
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < this.invoices.size(); i++) {
            if (invoices.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void updateById(Scanner scanner) {
        try {
            System.out.println("Nhập id hoá đơn cần chỉnh sửa:");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index == -1) {
                System.out.println("Không tìm thấy hoá đơn cần sửa");
            } else {
                System.out.println("Nhập mã hoá đơn mới:");
                String updateCode = scanner.nextLine();
                invoices.get(index).setInvoiceCode(updateCode);
                System.out.println("Nhập số tiền mới:");
                float updateAmount = Float.parseFloat(scanner.nextLine());
                invoices.get(index).setAmount(updateAmount);
                System.out.println("Sửa hoá đơn thành công");
            }
        } catch (NumberFormatException e) {
            System.err.println("ID hoặc số tiền không hợp lệ. Vui lòng nhập số nguyên >= 0 cho ID và số thực >=0 cho số tiền");
        }
    }

    public void deleteById(Scanner scanner) {
        try {
            System.out.println("Nhập id hoá đơn cần xoá:");
            int id = Integer.parseInt(scanner.nextLine());
            int index = findIndexById(id);
            if (index == -1) {
                System.out.println("Không tìm thấy hoá đơn cần xoá");
            } else {
                invoices.remove(index);
                System.out.println("Xoá hoá đơn thành công");
            }
        } catch (NumberFormatException e) {
            System.err.println("ID không hợp lệ. Vui lòng nhập số nguyên >=0");
        }
    }
}
