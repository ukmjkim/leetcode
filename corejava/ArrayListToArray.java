import java.util.*;

public class ArrayListToArray {
	private static void practiceArrayListToArray() {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Book");
		myList.add("Bus");
		myList.add("Car");

		// Case 1
		// Exception: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String]
		// String[] myArray = (String[]) myList.toArray();

		// Case 1 more, Array to List
		String sampleString = "Cat,Dog,Elephant";
		String[] myStrArray = sampleString.split(",");
		List<String> myStrList = new ArrayList<String>(Arrays.asList(myStrArray));
		System.out.println(myStrList);

		// Case 2
		Object[] myArray2 = myList.toArray();
		for (Object myObject : myArray2) {
			System.out.println(myObject);
		}

		// Case 3
		String[] myArray3 = myList.toArray(new String[0]);
		System.out.println(Arrays.toString(myArray3));

		// Case 4
		ArrayList<Integer> myList4 = new ArrayList<Integer>();
		myList4.add(Integer.valueOf(100));
		myList4.add(Integer.valueOf(200));
		myList4.add(Integer.valueOf(300));
		Integer[] myArray4 = myList4.toArray(new Integer[0]);
		System.out.println(Arrays.toString(myArray4));

		// Case 5 - Java8
		Integer[] myArray5 = myList4.stream().toArray(Integer[]::new);
		System.out.println(Arrays.toString(myArray5));
	}

	public static void main(String[] args) {
		practiceArrayListToArray();
	}
}
