package ra.presentation;
import ra.entity.Cat;
import ra.entity.Dog;
import ra.entity.Pet;

import java.util.Scanner;

public class PetManagement {
    public static Pet[] arrayPets = new Pet[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***********QUẢN LÝ THÚ CƯNG**************");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayListPets(sc);
                    break;
                case 2:
                    addPet(sc);
                    break;
                case 3:
                    petSpeak(sc);
                    break;
                case 4:
                    deletePetById(sc);
                    break;
                case 5:
                    searchPetByName(sc);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }

    public static void displayListPets(Scanner sc) {
        for (int i = 0; i < currentIndex; i++) {
            arrayPets[i].displayData();
        }
    }

    public static void addPet(Scanner sc) {
        System.out.println("Nhập loại thú cưng muốn nhập thông tin (Dog|Cat):");
        String petType = sc.nextLine();
        switch (petType) {
            case "Dog":
                arrayPets[currentIndex] = new Dog();
                break;
            default:
                arrayPets[currentIndex] = new Cat();
                break;
        }
        arrayPets[currentIndex].inputData(sc);
        currentIndex++;
    }

    public static void petSpeak(Scanner sc) {
        for (int i = 0; i < currentIndex; i++) {
            arrayPets[i].speak();
        }
    }

    public static int findIndexById(String petId) {
        for (int i = 0; i < currentIndex; i++) {
            if (arrayPets[i].getPetId().equals(petId)) {
                return i;
            }
        }
        return -1;

    }

    public static void deletePetById(Scanner sc) {
        System.out.println("Nhập vào mã thú cưng cần xóa:");
        String petId = sc.nextLine();
        int indexDeleted = findIndexById(petId);
        if (indexDeleted != -1) {
            for (int i = indexDeleted; i < currentIndex - 1; i++) {
                arrayPets[i] = arrayPets[i + 1];
            }
            arrayPets[currentIndex - 1] = null;
            currentIndex--;
        } else {
            System.err.println("Mã thú cưng không tồn tại");
        }
    }

    public static void searchPetByName(Scanner sc) {
        int cntPets = 0;
        System.out.println("Nhập vào tên thú cưng cần tìm:");
        String petNameSearch = sc.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if(arrayPets[i].getPetName().toLowerCase().contains(petNameSearch.toLowerCase())) {
                arrayPets[i].displayData();
                cntPets++;
            }
        }
        System.out.printf("Tìm thấy %d thú cưng có tên chứa %s\n", cntPets, petNameSearch);
    }
}
