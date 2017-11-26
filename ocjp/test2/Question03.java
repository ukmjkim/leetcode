public class Question03 {
  public static void main(String[] args) {

    // =~-3 ==> 2
    // =~2 ==> -3
    int j = ~-3;

    System.out.println(Integer.toBinaryString(-3));
    System.out.println(Integer.toBinaryString(j));
    while (j < 7) {
      System.out.print(j + " ");

      if (j == 3) {
        j += 2;
        continue;
      }

      j++;
    }
    System.out.println();
  }
}

/* Answer: 2 3 5 6 */
