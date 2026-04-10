package step4;

public class User {
    private int age;
    private String name;

    public User(int age,String name){
        this.age = age;
        this.name = name;

    }
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        if(age < 0){
            System.out.println("올바르지 않은 나이입니다");
            return ;
        }
        this.age = age;
    }

    public void printinfo(){
        System.out.println("이름: " + name + "| 나이: " + age + "세");
    }

}
