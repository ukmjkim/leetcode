import java.util.*;
import java.text.DecimalFormat;

public class StringFormat {
	public static void practiceNumericToString() {
		System.out.println(Float.toString(-895.25f));
		System.out.println(String.valueOf(-895.25f));

		float number = -895.25f;
		String numberAsString = new Float(number).toString();

		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		System.out.println(decimalFormat.format(1222355.3655f));		// 1,222,355.38
		System.out.println(decimalFormat.format(1222355.6585f));		// 1,222,355.62
		System.out.println(decimalFormat.format(12223551.3655f));		// 12,223,551.00
		System.out.println(decimalFormat.format(12223551.6585f));		// 12,223,552.00

        System.out.println(String.format ("%,.2f", 1222355.3655f));		// 1,222,355.38
        System.out.println(String.format ("%,.2f", 1222355.6585f));		// 1,222,355.63
        System.out.println(String.format ("%,.2f", 12223551.3655f));	// 12,223,551.00
        System.out.println(String.format ("%,.2f", 12223551.6585f));	// 12,223,552.00

        System.out.println(String.format ("%,.12f", 0.000123123155f));	// 0.000123123158

		DecimalFormat decimalFormat4Float = new DecimalFormat("0.0000000000");
        System.out.println(decimalFormat4Float.format(0.0001231231f));
	}

	public static void practiceIntegerToBinary() {
		int number = 255;
		String binaryString = Integer.toBinaryString(number);
		System.out.println(number + " -> " + binaryString);
	}

	public static void main(String[] args) {
		practiceNumericToString();
		practiceIntegerToBinary();
	}
}
