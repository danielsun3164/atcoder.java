package abc.abc101_150.abc144;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(((a <= 9) && (b <= 9)) ? a * b : -1);
		}
	}
}
