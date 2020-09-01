package abc.abc081;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.nextLine();
			System.out.println(s.chars().filter(x -> x == '1').count());
		}
	}
}
