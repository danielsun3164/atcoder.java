package abc.abc101_150.abc104;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			System.out.println((r < 1200) ? "ABC" : (r < 2800) ? "ARC" : "AGC");
		}
	}
}
