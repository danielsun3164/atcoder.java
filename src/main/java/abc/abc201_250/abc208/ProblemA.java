package abc.abc201_250.abc208;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(((a <= b) & (b <= 6 * a)) ? "Yes" : "No");
		}
	}
}
