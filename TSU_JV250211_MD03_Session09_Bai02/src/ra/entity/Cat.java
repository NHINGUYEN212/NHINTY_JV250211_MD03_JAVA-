package ra.entity;

public class Cat extends Pet{

    public Cat() {
    }

    public Cat(String petId, int petAge, String petName) {
        super(petId, petAge, petName);
    }

    @Override
    public void speak() {
        System.out.println("Meo meo");
    }

}
