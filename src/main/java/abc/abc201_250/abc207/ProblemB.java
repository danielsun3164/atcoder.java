package abc.abc201_250.abc207;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
			int e = (c * d) - b;
			System.out.println((e > 0) ? ((a + e) - 1) / e : -1);
		}
	}
}
