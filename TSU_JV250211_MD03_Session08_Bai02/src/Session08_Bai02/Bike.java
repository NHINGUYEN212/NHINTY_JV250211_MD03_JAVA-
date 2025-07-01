package Session08_Bai02;

public class Bike extends Vehicle {
    public  Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike Name: " + getName() + ", Speed: " + getSpeed() + " km/h");
    }
}
