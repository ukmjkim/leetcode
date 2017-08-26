import java.nio.CharBuffer;

public class StringContains {
	private static void containsStringBuilder() {
        String phrase = "The quick brown fox";
        StringBuilder sb = new StringBuilder();
        sb.append("b");
        sb.append("r");
        sb.append("o");
        sb.append("w");
        sb.append("n");
        System.out.println("StringBuilder contents: " + sb.toString());
        System.out.println("Contains result: " + phrase.contains(sb));
	}

	private static void containsCharBuffer() {
        String phrase = "The quick brown fox";
        CharBuffer cb = CharBuffer.allocate(5);
        cb.append('b');
        cb.append('r');
        cb.append('o');
        cb.append('w');
        cb.append('n');
        cb.clear();
        System.out.println("Char Buffer contents: " + cb.toString());
        System.out.println("Contains result: " + phrase.contains(cb));
	}
	public static void main(String[] args) {
		System.out.println(("I am a student".indexOf("am") >= 0));
		System.out.println(("I am a student".toLowerCase().indexOf("Am".toLowerCase()) >= 0));

		containsStringBuilder();
		containsCharBuffer();
	}
}
