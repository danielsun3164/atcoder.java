package abc.abc101_150.abc145;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String s = scanner.next();
			System.out.println(((0 == (1 & n)) && s.substring(0, n / 2).equals(s.substring(n / 2))) ? "Yes" : "No");
		}
	}
}
