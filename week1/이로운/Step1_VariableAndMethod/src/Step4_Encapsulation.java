public class Step4_Encapsulation {
    static void main(String[] args) {

        User user1 = new User("홍길동",20);
        user1.printInfo();
        user1.setAge(-88);
        user1.printInfo();
    }
}
