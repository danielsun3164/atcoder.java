package abc.abc056;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(Math.max(0, Math.abs(a - b) - w));
		}
	}
}
