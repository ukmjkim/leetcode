import java.util.*;

public class Solution {
	public List<Integer> grayCode(int numberOfbits) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < 1<<numberOfbits; i++) result.add(i^i>>1);
		return result;
	}

	public int grayToBinary(int num) {
		int mask;
		for (mask = num >> 1; mask != 0; mask = mask >> 1) {
			num = num ^ mask;
		}
		return num;
	}

	public static void main(String[] args) {
		int numberOfbits = 4;
		Solution solution = new Solution();

		String stringFormat = "%" + String.valueOf(numberOfbits) + "s";
		System.out.println("Input: " + numberOfbits + " Format: " + stringFormat);
		List<Integer> graycode = solution.grayCode(numberOfbits);
		for (Integer code : graycode) {
			int binaryCode = solution.grayToBinary(code);
			String binaryCodeString = String.format(stringFormat, Integer.toBinaryString(binaryCode)).replace(' ', '0');
			String grayCodeString = String.format(stringFormat, Integer.toBinaryString(code)).replace(' ', '0');
			System.out.println("Binary Code: " + binaryCodeString + ", Gray Code: " + grayCodeString);
		}
	}
}
