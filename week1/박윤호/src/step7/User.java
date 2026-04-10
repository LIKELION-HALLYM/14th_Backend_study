package step7;

public class User {
    protected String name;
    protected int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("올바르지 않은 나이입니다.");
            return;
        }
        this.age = age;
    }

    public void printInfo() {
        System.out.println("이름: " + name + " | 나이: " + age + "세");
    }
}
