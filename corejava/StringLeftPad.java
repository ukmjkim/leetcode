public class StringLeftPad {
	public static String leftPad(String originalString, int length, char padCharacter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(padCharacter);
		}
		String padding = sb.toString();
		String paddedString = padding.substring(originalString.length()) + originalString;
		return paddedString;
	}
	public static void main(String[] args) {
		System.out.println(leftPad("TEST", 10, '+'));
	}
}
