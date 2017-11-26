class Car {
  private int wheelCount;
  private String vin;

  public Car(String vin) {
    this.vin = vin;
    this.wheelCount = 4;
  }

  public String drive() {
    return "zoom-zoom";
  }

  public String getInfo() {
    return "VIN: " + vin + " wheels: " + wheelCount;
  }
}

public class MeGo extends Car {
  public MeGo(String vin) {
    this.wheelCount = 3;
  }
}

/*
Answer:

D. insert a call to super(vin) in the MeGo constructor
E. change the wheelCount variable in Car to protected


Mijungs-MBP-2:ocjp MijungKimMacPro$ javac Constructor4.java
Constructor4.java:19: error: class MeGo is public, should be declared in a file named MeGo.java
public class MeGo extends Car {
       ^
Constructor4.java:20: error: constructor Car in class Car cannot be applied to given types;
  public MeGo(String vin) {
                          ^
  required: String
  found: no arguments
  reason: actual and formal argument lists differ in length
Constructor4.java:21: error: wheelCount has private access in Car
    this.wheelCount = 3;
        ^
3 errors

*/
