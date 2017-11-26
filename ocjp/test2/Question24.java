public class Question24 {
  public static void main(String[] args) {
    StringBuffer sb1 = new StringBuffer("Amit"); 
    StringBuffer sb2 = new StringBuffer("Amit"); 
    String ss1 = "Amit"; 
    System.out.println(sb1==sb2);
    System.out.println(sb1.equals(sb2));
    System.out.println(sb1.equals(ss1));
    System.out.println(sb1.toString() == sb2.toString());
    System.out.println(sb1.toString().equals(sb2.toString()));
    System.out.println(sb1.toString().equals(ss1));
    System.out.println("Poddar".substring(3));
  }
}

/*

Both StringBuffer, StringBuilder equals are Object's equals(). object references
When comparing two StringBuilder then compare String after toString()

Mijungs-MBP-2:test2 MijungKimMacPro$ java Question24
false
false
false
dar

*/

