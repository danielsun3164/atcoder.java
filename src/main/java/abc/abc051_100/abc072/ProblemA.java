package abc.abc051_100.abc072;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), t = scanner.nextInt();
			System.out.println((x > t) ? (x - t) : 0);
		}
	}
}
