package week1Pc.user;

public class Step5_Inheritance {
    public static void main(String[] args) {
        User user = new User("길동", 20);
        AdminUser ad = new AdminUser("지웅", 30, "SUPER_ADMIN");

        user.printInfo();
        ad.printInfo();
    }
}
