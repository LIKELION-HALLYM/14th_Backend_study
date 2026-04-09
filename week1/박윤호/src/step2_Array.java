public class step2_Array {
      public static void main(String[] args) {
        int[] arr = {90, 85, 78, 92, 88};
        for(int i = 0; i < arr.length; i++){
            System.out.print(i + 1 + "번 " + " 학생" + arr[i] + " 점");
            System.out.println();
        }
          int total = get_total(arr);
          System.out.print(total);
      }

    public static int get_total (int[] arr) {
          int sum = 0;
          for(int i = 0; i < arr.length; i++){
              sum += arr[i];

          }
          return sum;
    }
}
