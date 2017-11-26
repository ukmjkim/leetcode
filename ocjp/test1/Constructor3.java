class Employee {
  String name;
  double baseSalary;

  Employee(String name, double baseSalary) {
    this.name = name;
    this.baseSalary = baseSalary;
  }
}

public class SalesPerson extends Employee {
  double commission;
  public SalesPerson(String name, double baseSalary, double commission) {
    // insert code here
  }
}

/*
Answer:
  super(name, baseSalary);
  
  or

  super(name, baseSalary); this.commission = commission;
*/

