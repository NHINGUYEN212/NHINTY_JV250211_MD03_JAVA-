package Session07_Bai02;

public class Book {
    private  String title;
    private  String author;
    private  double price;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Giá không được âm.");
        } else  {
            this.price = price;
        }
    }
}
