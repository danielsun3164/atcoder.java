package abc.abc051_100.abc081;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(s.chars().filter(x -> '1' == x).count());
		}
	}
}
