package abc.abc151_200.abc196;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String x = scanner.next();
			int index = x.indexOf(".");
			System.out.println((index < 0) ? x : x.substring(0, index));
		}
	}
}
