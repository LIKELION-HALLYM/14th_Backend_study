package step4;

public class Step4_Encapsulation {
    public static void main(String[] args){

        User u1 = new User(20,"김철수");

        u1.setAge(25);

        u1.printinfo();
        u1.setAge(-1);
        u1.printinfo();




    }
}
