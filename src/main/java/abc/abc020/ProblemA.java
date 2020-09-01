package abc.abc020;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			System.out.println((1 == q) ? "ABC" : "chokudai");
		}
	}
}
