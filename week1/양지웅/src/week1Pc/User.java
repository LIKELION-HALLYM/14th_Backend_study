package week1Pc;

public class User {
    String name;
    int age;

    public User(String name, int age ) {
        this.name = name;
        this.age = age;
    }
    public void printInfo() {
        System.out.println("name "+ name + " age "+ age);
    }
    public static void main(String[] args) {
        User user1 = new User("지웅", 20);

        user1.printInfo();
    }
}
