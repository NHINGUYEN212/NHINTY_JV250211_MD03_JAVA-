package Session8_Bai05;

public class Category {
    private int id;
    private String name;
    private String description;

//    contructor co tham so

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
//  contructor khong co tham so

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Description: " + description;
    }
}
