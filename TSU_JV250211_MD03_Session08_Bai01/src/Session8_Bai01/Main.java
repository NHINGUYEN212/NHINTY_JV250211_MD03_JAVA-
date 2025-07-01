package Session8_Bai01;

public class Main {
    public static void main(String[] args) {
        Animals[] animals = new Animals[2];

        Dog dog1 = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat1 = new Cat("Whiskers", 2, "Ghi");

        animals[0] = dog1;
        animals[1] = cat1;

        for (Animals animal : animals) {
            animal.displayInfo();
            System.out.println("Âm thanh: " + animal.makeSound());
            System.out.println();
        }
    }

}
