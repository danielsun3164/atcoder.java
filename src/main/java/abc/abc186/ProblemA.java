package abc.abc186;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), w = scanner.nextInt();
			System.out.println(n / w);
		}
	}
}
