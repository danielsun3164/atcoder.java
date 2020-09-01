package abc.abc170;

import java.util.Scanner;

public class ProblemA {

	private static final int N = 5;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int result = 0;
			for (int i = 1; i <= N; i++) {
				int a = scanner.nextInt();
				if (0 == a) {
					result = i;
				}
			}
			System.out.println(result);
		}
	}
}
