package abc.abc051_100.abc090;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), m = scanner.nextLong();
			if (1L == n) {
				if (1L == m) {
					System.out.println(1);
				} else {
					System.out.println(m - 2);
				}
			} else {
				if (1L == m) {
					System.out.println(n - 2);
				} else {
					System.out.println((n - 2) * (m - 2));
				}
			}
		}
	}
}
