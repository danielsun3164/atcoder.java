package abc.abc008;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int s = scanner.nextInt();
			int t = scanner.nextInt();
			System.out.println(t - s + 1);
		}
	}
}
