package abc.abc078;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			System.out.println((n * 100 + m * 1800) * (1 << m));
		}
	}
}
