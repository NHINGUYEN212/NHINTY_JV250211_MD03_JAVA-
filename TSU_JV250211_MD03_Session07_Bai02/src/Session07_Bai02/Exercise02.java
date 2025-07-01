package Session07_Bai02;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Book myBook = new Book();

        myBook.setTitle("Java Programming");
        myBook.setAuthor("John Doe");
        myBook.setPrice(29.99);

        System.out.println("Tiêu đề: " + myBook.getTitle());
        System.out.println("Tác giả: " + myBook.getAuthor());
        System.out.println("Giá: " + myBook.getPrice());

        myBook.setPrice(35.5);
        System.out.println("Giá mới: " + myBook.getPrice());

        myBook.setPrice(-5);
    }
}
