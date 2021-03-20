package abc.abc101_150.abc144;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long answer = n - 1;
			for (long i = 2L; i * i <= n; i++) {
				if (0 == n % i) {
					answer = Math.min(answer, i + n / i - 2);
				}
			}
			System.out.println(answer);
		}
	}
}
