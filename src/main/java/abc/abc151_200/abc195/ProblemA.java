package abc.abc151_200.abc195;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int m = scanner.nextInt(), h = scanner.nextInt();
			System.out.println((0 == h % m) ? "Yes" : "No");
		}
	}
}
