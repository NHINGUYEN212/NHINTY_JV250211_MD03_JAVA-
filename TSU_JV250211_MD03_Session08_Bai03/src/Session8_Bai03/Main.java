package Session8_Bai03;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(6, 7);
        Square square = new Square(8);

        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");

        System.out.println("Circle color: " + circle.getColor());
        System.out.println("Rectangle color: " + rectangle.getColor());
        System.out.println("Square color: " + square.getColor());
    }
}
