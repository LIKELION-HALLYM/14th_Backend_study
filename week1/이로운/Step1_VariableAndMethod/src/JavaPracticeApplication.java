public class JavaPracticeApplication {
    static void main(String[] args) {
        String name = "이로운";
        int age = 25;

        System.out.println("name: " + name + " age: " + age);
        System.out.println(add(3, 5));
    }
    public static int add(int a, int b) {
        int n = a + b;
        return n;
    }
}
