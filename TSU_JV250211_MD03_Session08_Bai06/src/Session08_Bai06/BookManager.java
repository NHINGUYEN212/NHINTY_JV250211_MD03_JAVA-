package Session08_Bai06;

public class BookManager implements IBookManager{
    private Book[] books;
    private int count;
    public BookManager() {
        books = new Book[50];
        count = 0;
    }

    @Override
    public void addBook(Book book) {
        if (count >= books.length) {
            System.out.println("Danh sách đã đầy, không thể thêm sách mới.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(book.getIsbn())) {
                System.err.println("Sách với ISBN này đã tồn tại.");
                return;
            }
        }
        books[count] = book;
        count++;
        System.out.println("Thêm sách thành công.");
    }

    @Override
    public void removeBook(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];

                }
                books[count - 1] = null;
                count--;
                System.out.println("Đã xoá sách có ISBN: " + isbn);
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ISBN: "  + isbn);
    }

    @Override
    public void displayBooks() {
        if (count == 0) {
            System.out.println("Không có sách nào trong danh sách.");
            return;
        }
        System.out.println("--- DANH SÁCH SÁCH ---");
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].getDetails());
        }
    }
}
