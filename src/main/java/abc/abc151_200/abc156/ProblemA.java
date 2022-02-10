package abc.abc151_200.abc156;

import java.util.Scanner;

public class ProblemA {

	/** 参加回数しきい値 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), r = scanner.nextInt();
			System.out.println(r + 100 * (N - Math.min(n, N)));
		}
	}
}
