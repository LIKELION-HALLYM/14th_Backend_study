public class Step2_Array {
	public static void main(String[] args) {
		int[] scors = {90, 85, 78, 92, 88};
		System.out.println(getTotal(scors));
	}
	public static int getTotal(int[] scores) {
		int total = 0;
		for (int score: scores) {
			total += score;
		}
		return total;
	}
}
