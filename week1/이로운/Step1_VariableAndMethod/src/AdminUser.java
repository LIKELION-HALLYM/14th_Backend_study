public class AdminUser extends User {
    private String role;


    public AdminUser(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public void printInfo(){
        System.out.println("이름: " + name + " | 나이: " + age + " | 권한: " + role);

    }
}
