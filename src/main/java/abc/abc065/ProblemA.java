package abc.abc065;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			if (a >= b) {
				System.out.println("delicious");
			} else if (x + a >= b) {
				System.out.println("safe");
			} else {
				System.out.println("dangerous");
			}
		}
	}
}
