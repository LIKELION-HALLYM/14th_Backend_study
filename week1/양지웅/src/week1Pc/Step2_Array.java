package week1Pc;

public class Step2_Array {
    public static void main(String[] args) {
        int[] scores = {90, 85, 78, 92, 88};


        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + 1 + "번 학생" + scores[i]);
        }

        System.out.println("합은: " + getTotal(scores));

    }


    static int getTotal(int[] scores) {
        int total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        return total;

    }


}