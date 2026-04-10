package step1;

public class JavaPracticeApplication {

    public static void main(String[] args) {
        String name = "박윤호";
        int age = 20;
        System.out.println("이름 : " + name + " 나이 " + age);
        System.out.print(add(6,10));

    }


    public static int add(int a, int b) {
        return a + b;
    }
}
