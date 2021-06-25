package abc.abc101_150.abc148;

import java.util.Scanner;

public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long answer = 0L;
			if (0L == (1L & n)) {
				for (long i = 10; i <= n; i *= 5) {
					answer += n / i;
				}
			}
			System.out.println(answer);
		}
	}
}
