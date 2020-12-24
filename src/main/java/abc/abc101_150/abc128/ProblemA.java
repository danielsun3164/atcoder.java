package abc.abc101_150.abc128;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), p = scanner.nextInt();
			System.out.println((a * 3 + p) / 2);
		}
	}
}
