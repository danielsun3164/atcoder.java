package abc.abc006;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			int n = Integer.parseInt(s);
			if (s.contains("3") || (0 == n % 3)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
