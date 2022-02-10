package abc.abc201_250.abc212;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] x = scanner.next().toCharArray();
			boolean result1 = true, result2 = true;
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i] != x[i + 1]) {
					result1 = false;
				}
				if (x[i + 1] != ((x[i] - '0' + 1) % 10) + '0') {
					result2 = false;
				}
			}
			System.out.println((result1 || result2) ? "Weak" : "Strong");
		}
	}
}
