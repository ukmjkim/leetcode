import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class City implements Comparable<City> {
  private String name;
  private String province;
  private int population;

  public City(String name, String province, int population) {
    this.name = name;
    this.province = province;
    this.population = population;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(City compareCity) {
    String compareCityName = compareCity.getName();
    return this.name.compareTo(compareCityName);
  }

  @Override
  public String toString() {
    return "Name: " + name + ", Province: " + province + ", Population: " + population;
  }
}

class Student {
  private String name;
  private String classname;
  private int studentid;

  public Student(String name, String classname, int studentid) {
    this.name = name;
    this.classname = classname;
    this.studentid = studentid;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getStudentID() {
    return this.studentid;
  }
  public void setStudentID(int studentid) {
    this.studentid = studentid;
  }

  public static Comparator<Student> StudentNameComparator = new Comparator<Student>() {
    public int compare(Student s1, Student s2) {
      String studentName1 = s1.getName().toUpperCase();
      String studentName2 = s2.getName().toUpperCase();

      return studentName1.compareTo(studentName2);
    }
  };

  public static Comparator<Student> StudentIDComparator = new Comparator<Student>() {
    public int compare(Student s1, Student s2) {
      int studentID1 = s1.getStudentID();
      int studentID2 = s2.getStudentID();

      return studentID1 - studentID2;
    }
  };

  @Override
  public String toString() {
    return "Name: " + name + ", ClassName: " + classname + ", StudentID: " + studentid;
  }
}

public class ArrayListExample {
  private static void removeDuplicates(List<String> list) {
    Set<String> set = new LinkedHashSet<>();
    set.addAll(list);
    list.clear();
    list.addAll(set);
  }

  private static void sortTest() {
    ArrayList<City> citylist = new ArrayList<City>(){{
        add(new City("Vancouver", "BC", 1000));
        add(new City("Toronto", "ON", 1000));
        add(new City("Calgary", "AB", 1000));
      }};

    System.out.println(citylist);
    Collections.sort(citylist);
    for (City city : citylist) {
      System.out.println(city);
    }

    ArrayList<Student> studentList = new ArrayList<Student>();
    studentList.add(new Student("Winnie", "Div8", 1));
    studentList.add(new Student("Michael", "Div7", 2));
    Collections.sort(studentList, Student.StudentNameComparator);
    for (Student student : studentList) {
      System.out.println(student);
    }
    Collections.sort(studentList, Student.StudentIDComparator);
    for (Student student : studentList) {
      System.out.println(student);
    }

  }

  private static void synchronizedListTest() {
    List<String> syncal = Collections.synchronizedList(new ArrayList<>());

    syncal.add("Pen");
    syncal.add("NoteBook");
    syncal.add("Ink");

    System.out.println("Iterating synchronized ArrayList: ");
    synchronized(syncal) {
      Iterator<String> iterator = syncal.iterator();
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
      }
    }
  }

  private static void synchronizedListTest2() {
    CopyOnWriteArrayList<String> arrList = new CopyOnWriteArrayList<String>();
    arrList.add("Pen");
    arrList.add("NoteBook");
    arrList.add("Ink");

    System.out.println("Displaying synchronized ArrayList Elements: ");
    Iterator<String> itr = arrList.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }

  private static void trimToSizeTest() {
    ArrayList<Integer> list = new ArrayList<>(50);
    list.add(1);
    list.add(2);
    list.add(3);

    /* both results are the same. Java doesn't expose the capacity information. */
    /* It would be better to trim the size for good performance */
    System.out.println(list);
    list.trimToSize();
    System.out.println(list);

    list.ensureCapacity(50);
    list.add(4);
    System.out.println(list);
  }

  private static void copyToString() {
    List<String> list = new ArrayList<>();

    list.add("Pen");
    list.add("NoteBook");
    list.add("Ink");

    String[] stationary = new String[list.size()];
    int i=0;
    for (String el : list) {
      stationary[i++] = el;
    }
    System.out.println(Arrays.toString(stationary));


    String[] supplies = list.toArray(new String[list.size()]);
    i=0;
    for (String el : list) {
      supplies[i++] = el;
    }
    System.out.println(Arrays.toString(supplies));

  }

  public static void main(String[] args) {

    /* Initialize ArrayList */
    List<String> list = new ArrayList<>(Arrays.asList("Toronto", "Montreal", "Calgary"));

    /* ArrayList - add */
    list.add("Burnabyyy");
    list.add("New Westminster");

    System.out.printf("Currently the array list has following elements: %s\n", list);

    /* ArrayList - add element at the given index */
    list.add(0, "Vancouver");
    list.add(1, "North Vancouver");
    list.add(2, "Toronto");
    System.out.printf("two elements added: %s\n", list);

    /* ArrayList - remove element by index */
    list.remove(1);
    System.out.printf("index 1 has been removed: %s\n", list);

    /* ArrayList - remove element by element */
    list.remove("Toronto");
    System.out.printf("first Toronto has been removed: %s\n", list);


    /* ArrayList - find an element */
    list.set(list.indexOf("Burnabyyy"), "Burnaby");
    System.out.printf("Burnabyyy has been changed to Burnaby: %s\n", list);
    System.out.printf("Does the list contain 'Vancouver': %b\n", list.contains("Vancouver"));

    /* Loop ArrayList - Advanced For Loop */
    for (String str : list) {
      System.out.printf(" %s", str);
    }
    System.out.println("");

    /* Loop ArrayList - Iterator */
    Iterator itr = list.iterator();
    while (itr.hasNext()) {
      System.out.printf(" %s", itr.next());
    }
    System.out.println("");

    /* ArrayList - sort using Collections */
    Collections.sort(list);
    System.out.printf("Sorted array list is: %s\n", list);

    /* ArrayList - sort by descending using Collections */
    Collections.sort(list, Collections.reverseOrder());
    System.out.printf("Sorted array list is: %s\n", list);

    /* ArrayList - remove duuplicates */
    list.add("Vancouver");
    list.add("Vancouver");
    list.add("Calgary");
    list.add("Vancouver");
    list.add("Toronto");
    list.add("Vancouver");
    System.out.printf("array list having duplicates is: %s\n", list);
    removeDuplicates(list);
    System.out.printf("array list having unique elements is: %s\n", list);

    /* ArrayList - subList */
    List<String> subList = new ArrayList<>(list.subList(1, 4));
    System.out.printf("sub list: %s\n", subList);

    /* ArrayList - swap two elements in an ArrayList */
    Collections.swap(subList, 0, 1);
    System.out.printf("swap two elements in sub list: %s\n", subList);

    sortTest();

    synchronizedListTest();
    synchronizedListTest2();

    trimToSizeTest();

    copyToString();
  }
}

