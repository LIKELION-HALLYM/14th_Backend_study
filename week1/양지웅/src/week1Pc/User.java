package week1Pc;

import org.w3c.dom.ls.LSOutput;

public class User {
   private String name;
   private int age;

    public User(String name, int age ) {
        this.name = name;
        this.age = age;
    }
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }
    void setName(String name) {
        this.name = name;
    }
    void setAge(int age) {
        if(age<0) {
            System.out.println("올바르지 않은 나이입니다.");

        }
        this.age = age;
    }


    public void printInfo() {
        System.out.println("name "+ name + " age "+ age);
    }
    public static void main(String[] args) {
        User user1 = new User("지웅", 20);



        user1.setAge(25);

        user1.printInfo();


    }
}
