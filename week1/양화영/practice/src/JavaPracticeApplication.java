import java.util.Scanner;

public class JavaPracticeApplication {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name = "young";
		int age = 24;
		System.out.println("name: " + name + " age: " + age);
		//변수 지정
		System.out.println(add(3,5));

		//변수 입력
		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(add(a,b));

	}
	public static int add(int a, int b) {
		return a + b;
	}
}
