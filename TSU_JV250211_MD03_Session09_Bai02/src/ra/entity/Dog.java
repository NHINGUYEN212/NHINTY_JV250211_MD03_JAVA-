package ra.entity;

public class Dog extends Pet {

    public Dog() {
    }

    public Dog(String petId, int petAge, String petName) {
        super(petId, petAge, petName);
    }

    @Override
    public void speak() {
        System.out.println("Gâu gâu");
    }
}
