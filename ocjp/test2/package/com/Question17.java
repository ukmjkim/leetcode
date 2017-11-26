package com;

import static bean.Question17_Class.index_val;

public class Question17 {
  public static void main(String... args) {
    System.out.println(index_val);
  }
}

/*
Question17.java:1: error: cannot find symbol
import static Question17_Class.index_val;
              ^
  symbol: class Question17_Class
Question17.java:1: error: static import only from classes and interfaces
import static Question17_Class.index_val;
^
Question17.java:5: error: cannot find symbol
    System.out.println(index_val);
                       ^
  symbol:   variable index_val
  location: class Question17
3 errors
*/

