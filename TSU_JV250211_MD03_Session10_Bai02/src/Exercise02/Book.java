package Exercise02;

import java.util.Scanner;

public class Book {
    private String bookName;
    private String author;
    private int publicationYear;

    public Book() {
    }

    public Book(String bookName, String author, int publicationYear) {
        this.bookName = bookName;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void displayBook() {
        System.out.printf("Tên sách: %s, Tên tác giả: %s, Năm xuất bản: %d%n", bookName, author, publicationYear);
    }

    private String inputBookName(Scanner scanner) {
        String bookName = "";
        do {
            System.out.println("Nhập tên sách: ");
            bookName = scanner.nextLine();
            if (bookName.isEmpty()) {
                System.err.println("Tên sách không được để trống.");
            }

        } while (bookName.isEmpty());
        return bookName;
    }

    private String inputAuthor(Scanner scanner) {
        String author = "";
        do {
            System.out.println("Nhập tên tác giả: ");
            author = scanner.nextLine();
            if (author.isEmpty()) {
                System.err.println("Tên tác giả không được để trống.");
            }

        } while (author.isEmpty());
        return author;
    }

    private int inputPublicationYear(Scanner scanner) {
        String publicationYear = "";
        do {
            System.out.println("Nhập năm xuất bản:");
            publicationYear = scanner.nextLine();
            try {
                if (publicationYear.isEmpty()) {
                    System.err.println("Năm xuất bản không được để trống");
                    continue;
                } else if (Integer.parseInt(publicationYear) < 0) {
                    System.err.println("Vui lòng nhập số nguyên >= 0");
                } else {
                    return Integer.parseInt(publicationYear);
                }

            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên >= 0");
            }

        } while (true);
    }

    public void inputData(Scanner scanner) {
        this.bookName = inputBookName(scanner);
        this.author = inputAuthor(scanner);
        this.publicationYear = inputPublicationYear(scanner);

    }
}
