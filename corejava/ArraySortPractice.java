import java.util.*;

public class ArraySortPractice {
	public static void runArraySort(int[] nums) {
		Arrays.sort(nums);
	}

	public static void runArraySortWithPortion(int[] nums) {
		// fromIndex - the index of the first element (inclusive) to be sorted
		// toIndex - the index of the last element (exclusive) to be sorted
		Arrays.sort(nums, 2, 6);
	}

	public static void sortArrayOfCustomClass() {
		Person[] persons = new Person[5];
		persons[0] = new Person("Johnson", 5);
		persons[1] = new Person("Peter", 2);
		persons[2] = new Person("Anthony", 15);
		persons[3] = new Person("Sally", 8);
		persons[4] = new Person("Cory", 7);
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
	}

	public static void sortArrayOfCustomClassAndCustomComparator() {
		Student[] students = new Student[5];
		students[0] = new Student("Winnie", 8);
		students[1] = new Student("Michael", 6);
		students[2] = new Student("Hena", 9);
		students[3] = new Student("Yunno", 8);
		students[4] = new Student("Max", 6);
		Arrays.sort(students, Student.NAME_COMPARATOR);
		System.out.println(Arrays.toString(students));
		Arrays.sort(students, Student.GRADE_COMPARATOR);
		System.out.println(Arrays.toString(students));
	}

	// Fisher-Yates shuffle
	public static void shuffle(int[] nums) {
		int n = nums.length;
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			int randomValue = random.nextInt(n - 1);
			int randomElement = nums[randomValue];
			nums[randomValue] = nums[i];
			nums[i] = randomElement;
		}
	}

	public static void main(String[] args) {
		int[] input = {4, 5, 3, 2, 6, 1};
		System.out.print("Input: " + Arrays.toString(input));
		runArraySort(input);
		System.out.println(", Result: " + Arrays.toString(input));

		shuffle(input);
		System.out.print("Input: " + Arrays.toString(input));
		runArraySortWithPortion(input);
		System.out.println(", Result: " + Arrays.toString(input));

		Integer[] numInteger = {4, 5, 3, 2, 6, 1};
		Arrays.sort(numInteger, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return -1 * arg0.compareTo(arg1);
			}
		});
		System.out.println(Arrays.toString(numInteger));

		sortArrayOfCustomClass();
		sortArrayOfCustomClassAndCustomComparator();
	}
}

class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "[name: " + name + ", age: " + age + "]";
	}
	@Override
	public int compareTo(Person o) {
		return Integer.valueOf(age).compareTo(o.age);
	}
}

class Student {
	public static Comparator<Student> GRADE_COMPARATOR = new Comparator<Student>() {
		@Override
		public int compare(final Student s1, final Student s2) {
			return Integer.valueOf(s1.grade).compareTo(s2.grade);
		}
	};
	public static Comparator<Student> NAME_COMPARATOR = new Comparator<Student>() {
		@Override
		public int compare(final Student s1, final Student s2) {
			return s1.name.compareTo(s2.name);
		}
	};

	String name;
	int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	public String toString() {
		return "[name: " + this.name + ", grade: " + this.grade + "]";
	}
}
