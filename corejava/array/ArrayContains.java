import java.util.*;

public class ArrayContains {
	private static void practiceBinarySearch() {
		int[] myArray = {5, 2, 17, 13, 12, 19, 7, 3, 9, 15};

		// Case 1 => incorrect, the array is not sorted
		int index = Arrays.binarySearch(myArray, 13);
		System.out.println("Found: " + (index >= 0));

		// Case 2
		Arrays.sort(myArray);
		int index2 = Arrays.binarySearch(myArray, 13);
		System.out.println("Found: " + (index2 >= 0));

		// Case 3 => exception, primitive int conversion
		/*
		List<Integer> myList = new ArrayList<Integer>(Arrays.asList(myArray));
		System.out.println(myList.contains(13));
		*/

		// Case 5
		List<Integer> myList5 = new ArrayList<Integer>();
		for (int i = 0; i < myArray.length; i++) {
			myList5.add(myArray[i]);	
		}
		System.out.println(myList5.contains(13));

		// Case 6
		Set<Integer> set = new HashSet<Integer>(myList5);
		System.out.println(set.contains(13));

		// Case 7 - Java8
		Integer item = new Integer(13);
		System.out.println(Arrays.stream(myArray).anyMatch(item::equals));
	}

	public static void main(String[] args) {
		practiceBinarySearch();
	}
}
