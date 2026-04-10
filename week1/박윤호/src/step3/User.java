package step3;

public class User {
    int age;
    String name;

    public User(String name, int age){
        this.name = name;
        this.age = age;


    }

    public User (String name) {

    }

//    public step3.User () {};


    public void printinfo(){

        System.out.println("이름: " + name + "| 나이: " + age + "세");
    }
}
