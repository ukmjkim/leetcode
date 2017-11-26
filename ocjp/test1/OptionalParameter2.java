import java.util.*;
public class OptionalParameter2 {
  public static void main(String[]...args) {
    System.out.println(Arrays.toString(args));
  }
}

/*
Questions: possible code fragments for main

public static void main(String...a) {}
public static void main(String... a) {}
public static void main(String[]...a) {}



public static void main(String[]...a) {}, has runtime error

Mijungs-MBP-2:ocjp MijungKimMacPro$ java OptionalParameter2
Error: Main method not found in class OptionalParameter2, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
*/


