class Animal {
  public void printName() {
    System.out.println("Animal");
  }
}

class Cat extends Animal {
  public void printName() {
    System.out.println("Cat");
  }
}

public class Question03 {
  public static void main(String...args) {
    Animal a = new Cat();
    a.printName();
  }
}

