package abc.abc006;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			// 大人、老人、赤ちゃんの数
			int a = 0, b = 0, c = 0;
			if ((m < n * 2) || (m > n * 4)) {
				a = b = c = -1;
			} else {
				if (0 == (m % 2)) {
					c = getTsurukame(n, m);
					a = n - c;
				} else {
					c = getTsurukame(n - 1, m - 3);
					b = 1;
					a = n - c - b;
				}
			}
			System.out.println(a + " " + b + " " + c);
		}
	}

	/**
	 * 鶴亀計算
	 * 
	 * @param n 個体の数
	 * @param m 足の数
	 * @return 亀の数（赤ちゃんの数）
	 */
	private static int getTsurukame(int n, int m) {
		int tsuru = m / 2;
		int kame = tsuru - n;
		tsuru = n - kame;
		return kame;
	}
}
