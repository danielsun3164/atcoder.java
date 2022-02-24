package abc.abc151_200.abc161;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), k = scanner.nextLong(), d = n % k;
			System.out.println(Math.min(d, k - d));
		}
	}
}
