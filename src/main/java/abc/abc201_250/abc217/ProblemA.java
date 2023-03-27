package abc.abc201_250.abc217;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next(), t = scanner.next();
			System.out.println((s.compareTo(t) < 0) ? "Yes" : "No");
		}
	}
}
