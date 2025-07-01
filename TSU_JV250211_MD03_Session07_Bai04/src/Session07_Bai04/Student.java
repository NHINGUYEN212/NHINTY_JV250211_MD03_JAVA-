package Session07_Bai04;

public class Student {
    private String name;
    private int age;
    private String className;
    private double avgScore;
    public Student(String name, int age, String className, double avgScore) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.avgScore = avgScore;
    }
    public String toString() {
        return "Tên: " + name + ", Tuổi: " + age + ", Lớp: " + className + ", Điểm trung bình: " + avgScore;
    }

    public double getAvgScore() {
        return avgScore;
    }
}
