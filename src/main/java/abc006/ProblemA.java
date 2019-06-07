package abc006;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			int n = Integer.parseInt(s);
			if (s.contains("3") || (0 == n % 3)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
