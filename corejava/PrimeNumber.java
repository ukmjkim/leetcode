public class PrimeNumber {
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}

		int numberOfDivisor = 0;
		for (int i = 1; i <= n; i++) {
			if ((n % i) == 0) {
				numberOfDivisor++;
			}
		}

		return (numberOfDivisor == 2);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
}
