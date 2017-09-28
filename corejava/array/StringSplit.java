import java.util.*;

public class StringSplit {
    private static void practiceStringSplit() {
        String[] shapes = "Circle,Square,Rectangle,Hexagon".split(",", 2);
        System.out.println(Arrays.toString(shapes));

        shapes = "Circle,Square,Rectangle,Hexagon".split(",", 0);
        System.out.println(Arrays.toString(shapes));

        shapes = "Circle,Square,Rectangle,Hexagon".split(",", 1);
        System.out.println(Arrays.toString(shapes));

        shapes = "Circle,Square,Rectangle,Hexagon".split(",", 3);
        System.out.println(Arrays.toString(shapes));

		System.out.println(Arrays.toString(",A,B,,,,,,,,,,,C".split(",")));
		System.out.println(Arrays.toString("A,B,C,,,,,,,,,,".split(",")));
		System.out.println(Arrays.toString("A,B,C,,,,,,,,,,".split(",", -1)));
    }

	private static void practiceSplitWithRegularExpression() {
		String sampleSentence = "The quick     brown\tfox\njumps\n\nover   the\tlazy\r\ndog";

		// Regular Expression
		// Whitespace characters are the following: tab, space, and line feed
		// \s stands for a whitespace
		// A sequence of one or more whitespaces can be expressed as \s+
		// scape \ when we use in Java

		String[] words = sampleSentence.split("\\s+");
		int itemCount = words.length;
		System.out.println("The number of words is: " + itemCount);
		System.out.println(Arrays.toString(words));

		// Regular Expression
		// Since dot has special meaning, we can only use it by escaping with the \ character
		// Trimming whitespace
		String sampleString = "A .  B .   C";
		String[] items = sampleString.split("\\s*\\.\\s*");
		System.out.println(Arrays.toString(items));

		// Regular Expression
		// *Nix environment, ilnes are just separated by the character "\n", In Windows, it is "\r\n"
		// For both environment, "\r?\n" "\r" is optional while "\n" is required.
		// Trimming whitespace
		String nixSampleLine = "Line 1 \n Line 2 \n Line 3";
		String[] lines = nixSampleLine.split("\\s*\\r?\\n\\s*");
		System.out.println(Arrays.toString(lines));

		String sampleLineWithPipe = "A  |  B  | C";
		String[] linesAfterSplit = sampleLineWithPipe.split("\\s*\\|\\s*");
		System.out.println(Arrays.toString(linesAfterSplit));

		System.out.println(Arrays.toString("abc123def456ghi789".split("\\d+")));
		System.out.println(Arrays.toString("123abc456def789".split("[a-zA-Z]+")));
	}
	public static void main(String[] args) {
		practiceStringSplit();
		practiceSplitWithRegularExpression();
	}
}
