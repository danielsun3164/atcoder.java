package abc.abc201_250.abc240;

import java.util.Scanner;

public class ProblemA {

	/** 点の数 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(((a == next(b) || (a == prev(b))) ? "Yes" : "No"));
		}
	}

	/**
	 * 一つ次のノードを取得する
	 *
	 * @param now 現在のノード
	 * @return 一つ次のノード
	 */
	private static int next(int now) {
		return (N == now) ? 1 : now + 1;
	}

	/**
	 * 一つ前のノードを取得する
	 *
	 * @param now 現在のノード
	 * @return 一つ前のノード
	 */
	private static int prev(int now) {
		return (1 == now) ? N : now - 1;
	}
}
