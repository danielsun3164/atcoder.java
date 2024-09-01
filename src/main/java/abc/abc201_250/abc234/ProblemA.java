package abc.abc201_250.abc234;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			System.out.println(f(f(f(t) + t) + f(f(t))));
		}
	}

	/**
	 * f(x)を計算する
	 *
	 * @param x
	 * @return f(x)
	 */
	private static int f(int x) {
		return x * x + 2 * x + 3;
	}
}
