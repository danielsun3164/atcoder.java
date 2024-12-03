package abc.abc201_250.abc237;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println(((n >= Integer.MIN_VALUE) && (n <= Integer.MAX_VALUE)) ? "Yes" : "No");
		}
	}
}
