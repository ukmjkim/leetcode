import java.util.*;

public class ArraySplit {
	private static void practiceSplit() {
		String sampleString = "101,203,405";
		String[] stringArray = sampleString.split(",");
		int[] intArray = new int[stringArray.length];
		for (int i =0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		System.out.println(Arrays.toString(intArray));
	}

	private static void practiceArrayToList() {
		String sampleString = "Cat,Dog,Elephant";
		String[] items = sampleString.split(",");
		List<String> myList = new ArrayList<String>(Arrays.asList(items));
		System.out.println(myList);
	}

	public static void main(String[] args) {
		practiceSplit();
		practiceArrayToList();
	}
}
