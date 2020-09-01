package abc.abc013;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String x = scanner.nextLine();
			System.out.println(x.charAt(0) - 'A' + 1);
		}
	}
}
