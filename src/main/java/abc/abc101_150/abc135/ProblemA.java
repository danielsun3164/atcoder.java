package abc.abc101_150.abc135;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			int diff = Math.abs(a - b);
			System.out.println((0 == (diff & 1)) ? String.valueOf((diff >> 1) + Math.min(a, b)) : "IMPOSSIBLE");
		}
	}
}
