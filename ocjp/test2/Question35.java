import java.util.Properties;

class Question35 {
  public static void main(String[] args) {
    Properties p = System.getProperties();
    System.out.println(p.getProperty("key1"));
  }
}



/*


Mijungs-MBP-2:test2 MijungKimMacPro$ java -Dkey1=value1 Question35
value1


*/

