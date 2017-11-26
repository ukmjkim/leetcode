import java.io.*;

public class Question31 {
  public static void main(String... args) throws Exception {
    File file = new File("test.txt"); 
    System.out.println(file.exists());
    file.createNewFile(); 
    System.out.println(file.exists());
  }
}

