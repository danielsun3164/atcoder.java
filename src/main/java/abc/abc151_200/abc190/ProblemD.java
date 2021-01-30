package abc.abc151_200.abc190;

import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			int answer = 0;
			for (long i = 1L; i * i <= 2 * n; i++) {
				if (0 == 2 * n % i) {
					if ((i & 1) + ((2 * n / i) & 1) == 1) {
						answer += 2;
					}
				}
			}
			System.out.println(answer);
		}
	}
}
