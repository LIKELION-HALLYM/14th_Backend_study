package step7;

public class AdminUser extends User {
    private String role;

    public AdminUser(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public void printInfo() {
        System.out.println("[관리자] 이름: " + name + " | 나이: " + age + "세 | 권한: " + role);
    }
}
