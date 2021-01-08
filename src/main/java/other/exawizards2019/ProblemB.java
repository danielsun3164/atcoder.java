package other.exawizards2019;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String s = scanner.next();
			System.out.println((s.chars().filter(x -> 'R' == x).count() > n / 2) ? "Yes" : "No");
		}
	}
}
