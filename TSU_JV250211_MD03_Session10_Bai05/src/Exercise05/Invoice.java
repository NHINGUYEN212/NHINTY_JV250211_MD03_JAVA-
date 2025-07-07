package Exercise05;

import java.util.Scanner;

public class Invoice {
    private int id;
    private String invoiceCode;
    private float amount;

    public Invoice() {
    }

    public Invoice(int id, String invoiceCode, float amount) {
        this.id = id;
        this.invoiceCode = invoiceCode;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void displayData() {
        System.out.printf("ID: %d, Mã hoá đơn: %s, Số tiền: %.2f%n", id, invoiceCode, amount);
    }

    private int inputId(Scanner scanner) {
        String input = "";
        int inputId;
        while (true) {
            System.out.println("Nhập ID cho hoá đơn");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.err.println("ID không được để trống");
                continue;
            }
            try {
                inputId = Integer.parseInt(input);

                if (inputId < 0) {
                    System.err.println("Vui lòng nhập số nguyên >= 0");
                } else {
                    return inputId;
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên >= 0");
            }
        }
    }

    private String inputInvoiceCode(Scanner scanner) {
        String inputInvoiceCode = "";
        while (true) {
            System.out.println("Nhập mã hoá đơn");
            inputInvoiceCode = scanner.nextLine();
            if (inputInvoiceCode.isEmpty()) {
                System.err.println("Mã hoá đơn không được để trống");
                continue;
            } else {
                return inputInvoiceCode;
            }
        }
    }

    private float inputAmount(Scanner scanner) {
        String input = "";
        while (true) {
            System.out.println("Nhập số tiền:");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.err.println("Số tiền không được để trống");
                continue;
            }
            try {
                float inputAmount = Float.parseFloat(input);
                if (inputAmount < 0) {
                    System.err.println("Vui lòng nhập số thực >= 0");
                } else {
                    return inputAmount;
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số thực >= 0");
            }
        }
    }

    public void inputData(Scanner scanner) {
        this.id = inputId(scanner);
        this.invoiceCode = inputInvoiceCode(scanner);
        this.amount = inputAmount(scanner);
    }
}
