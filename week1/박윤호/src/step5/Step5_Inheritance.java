package step5;

public class Step5_Inheritance {
    static void main() {
        User u1 = new User(20,"김철수");
        AdminUser a1 = new AdminUser("김철",19, "어드민");

        u1.printinfo();
        a1.printinfo();
    }
}
