public class Question45 {
  public static void main(String[] args) {
    byte a=5;
    int b=10;

    // a>>2; ==> 101 >> 2 ==> 1
    // a>>2+b; ==> 1 >> (2 + 10) => 0
    // 0 >> 2  ==> 2
    int c=a>>2+b>>2;
    System.out.println(a>>2);
    System.out.println(a>>(2+b));
    System.out.println(a>>2+b>>2);
  }
}

/*

0

*/
