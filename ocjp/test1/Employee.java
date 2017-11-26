class Person {
  String name = "No name";
  public Person(String nm) { name = nm; }
}

public class Employee extends Person {
  String empID = "0000";
  public Employee(String id) { empID = id; }

  public static void main(String[] args) {
    Employee e = new Employee("name", "4321");
    System.out.println(e.empID);
  }
}

/*
Explanation: Compilation fails because of an error in line 8.
Employee.java:8: error: constructor Person in class Person cannot be applied to given types;
  public Employee(String id) { empID = id; }
                             ^
  required: String
  found: no arguments
  reason: actual and formal argument lists differ in length
1 error

Correction:
  public Employee(String nm, String id) { super(nm); empID = id; }
*/

