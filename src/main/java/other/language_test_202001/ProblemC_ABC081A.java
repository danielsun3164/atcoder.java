package other.language_test_202001;

import java.util.Scanner;

public class ProblemC_ABC081A {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String s = scanner.next();
			System.out.println(s.chars().filter(x -> '1' == x).count());
		}
	}
}
