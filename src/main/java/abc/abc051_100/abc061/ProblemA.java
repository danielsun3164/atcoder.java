package abc.abc051_100.abc061;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
			System.out.println(((c >= a) && (c <= b)) ? "Yes" : "No");
		}
	}
}
