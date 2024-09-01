package abc.abc201_250.abc227;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), answer = 0L;
			for (long a = 1L; a * a * a <= n; a++) {
				long bc = n / a;
				for (long b = a; b * b * a <= n; b++) {
					answer += bc / b - b + 1;
				}
			}
			System.out.println(answer);
		}
	}
}
