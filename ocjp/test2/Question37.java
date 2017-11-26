public class Question37 {
  public static void main(String[] args) {
    byte b = 6;
    b+=8;
    System.out.println(b);

    b = b + 7;
    System.out.println(b);
  }
}


/*

b+=7          --> no compilation error
b = b + 7     --> compilation error: incompatible type


/tmp/java_tduUTy/Test.java:7: error: incompatible types: possible lossy conversion from int to byte
  b = b + 7;
        ^
1 error

*/
