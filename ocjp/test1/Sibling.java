class Animal {
  public String noise() {
    return "peep";
  }
}

class Dog extends Animal {
  public String noise() {
    return "bark";
  }
}

class Cat extends Animal {
  public String noise() {
    return "meow";
  }
}

public class Sibling {
  public static void main(String[] args) {
    Animal animal = new Dog();
    Cat cat = (Cat) animal;
    System.out.println(cat.noise());
  }
}

/*
Mijungs-MBP-2:ocjp MijungKimMacPro$ java Sibling
Exception in thread "main" java.lang.ClassCastException: Dog cannot be cast to Cat
  at Sibling.main(Sibling.java:22)
*/

