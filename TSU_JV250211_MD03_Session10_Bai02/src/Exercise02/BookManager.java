package Exercise02;

import java.util.HashMap;
import java.util.Scanner;

public class BookManager {
    private HashMap<String, Book> books;

    public BookManager() {
        books = new HashMap<>();
    }

    public void addBook(Scanner scanner) {
        Book book = new Book();
        book.inputData(scanner);
        books.put(book.getBookName(), book);
    }

    public void findBook(Scanner scanner) {
        System.out.println("Nhập tên sách cần tìm:");
        String findName = scanner.nextLine();
        boolean found = false;
        for (Book book : books.values()) {
            if (book.getBookName().toLowerCase().contains(findName.toLowerCase())) {
                book.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + findName);
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách trống");
        }
        for (Book book : books.values()) {
            book.displayBook();
        }
    }
}
