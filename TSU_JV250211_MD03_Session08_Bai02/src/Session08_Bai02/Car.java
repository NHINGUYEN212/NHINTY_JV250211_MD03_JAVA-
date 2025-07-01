package Session08_Bai02;

public class Car extends Vehicle {
    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Name: " + getName() + ", Speed: " + getSpeed() + " km/h");
    }
}
