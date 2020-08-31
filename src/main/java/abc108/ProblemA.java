package abc108;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			System.out.println((k + 1) / 2 * (k / 2));
		}
	}
}
