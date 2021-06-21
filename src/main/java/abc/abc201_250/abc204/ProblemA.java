package abc.abc201_250.abc204;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			System.out.println((x == y) ? x : 3 - x - y);
		}
	}
}
