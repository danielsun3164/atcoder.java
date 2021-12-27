package abc.abc151_200.abc154;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next(), t = scanner.next();
			int a = scanner.nextInt(), b = scanner.nextInt();
			String u = scanner.next();
			System.out.println((s.equals(u) ? a - 1 : a) + " " + (t.equals(u) ? b - 1 : b));
		}
	}
}
