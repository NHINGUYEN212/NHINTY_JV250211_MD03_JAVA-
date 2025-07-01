package Session8_Bai01;

public class Cat extends Animals {
    private String furColor;
    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Màu lông: " + furColor);
    }
}
