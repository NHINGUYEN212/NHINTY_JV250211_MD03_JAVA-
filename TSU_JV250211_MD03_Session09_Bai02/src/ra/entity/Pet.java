package ra.entity;

import ra.presentation.PetManagement;

import java.util.Scanner;

public abstract class Pet implements IAnimal {
    private String petId;
    private String petName;
    private int petAge;

    public Pet() {
    }

    public Pet(String petId, int petAge, String petName) {
        this.petId = petId;
        this.petAge = petAge;
        this.petName = petName;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public abstract void speak();

    @Override
    public void inputData(Scanner sc) {
        this.petId = inputPetId(sc);
        this.petName = inputPetName(sc);
        this.petAge = inputPetAge(sc);
    }

    public String inputPetId(Scanner sc) {
        String petIdRegex ="[CD]\\d{3}";
        System.out.println("Nhập vào mã thú cưng:");

        do {
            String petId = sc.nextLine();
            if(petId.matches(petIdRegex)) {
                boolean isExist = false;
                for (int i = 0; i < PetManagement.currentIndex; i++) {
                    if (PetManagement.arrayPets[i].getPetId().equals(petId)) {
                        isExist = true;
                        break;
                    }
                }
                if(isExist) {
                    System.err.println("Mã thú cưng đã tồn tại, vui lòng nhập lại");
                } else {
                    return petId;
                }
            } else {
                System.err.println("Mã thú cưng gồm 4 ký tự, bắt đầu là C | D, 3 ký tự sau là số, vui lòng nhập lại!");
            }

        } while(true);
    }
    public String inputPetName(Scanner sc) {
        System.out.println("Nhập vào tên thú cưng:");
        do {
            String petname = sc.nextLine();
            if (petname.length() >= 20 && petname.length() <= 50) {
                return petname;
            } else {
                System.err.println("Tên thú cưng có từ 20-50 ký tự, vui lòng nhập lại");
            }

        } while(true);
    }

    public int inputPetAge(Scanner sc) {
        System.out.println("Nhập vào tuổi của thú cưng:");
        do {
            if (sc.hasNextInt()) {
                int petAge = Integer.parseInt(sc.nextLine());
                if (petAge > 0) {
                    return petAge;
                } else {
                    System.err.println("Tuổi thú cưng phải lớn hơn 0, vui lòng nhập lại");
                }
            } else {
                System.err.println("Tuổi thú cưng phải là số nguyên, vui lòng nhập lại");
            }

        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã thú cưng: %s - Tên thú cưng: %s - Tuổi: %d%n", this.petId, this.petName, this.petAge);
    }
}
