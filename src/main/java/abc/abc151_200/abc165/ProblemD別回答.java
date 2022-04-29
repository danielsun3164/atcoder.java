package abc.abc151_200.abc165;

import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			long b = scanner.nextLong(), n = scanner.nextLong();
			System.out.println(fn(a, b, Math.min(b - 1, n)));
		}
	}

	/**
	 * floor(Ax/B)−A*floor(x/B) を計算する
	 *
	 * @param a A
	 * @param b B
	 * @param x x
	 * @return floor(Ax/B)−A*floor(x/B) を計算する
	 */
	private static long fn(int a, long b, long x) {
		return a * x / b - a * (x / b);
	}
}
