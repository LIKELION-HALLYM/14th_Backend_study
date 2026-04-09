package week1Pc.user;

public class AdminUser extends User {

    String role;
    public AdminUser(String name, int age,String role) {
        super(name, age);
        this.role = role;


    }
    @Override
    public void printInfo() {
        System.out.println("[관리자] 이름: "+name +" | 나이: "+ age +" | 권환: "+ role );

    }
}
