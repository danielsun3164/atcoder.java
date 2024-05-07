package abc.abc201_250.abc224;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc224/editorial/7409 の実装<br/>
 * https://atcoder.jp/contests/abc224/submissions/46503447 にも参考
 */
public class ProblemG別回答 {

	/** 計算回数の上限 */
	private static final int N = 1_000_000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), s = scanner.nextLong(), t = scanner.nextLong(), a = scanner.nextLong(),
					b = scanner.nextLong();
			double answer = b * (double) n;
			for (int i = 0; i < N; i++) {
				double cost = b * (double) n, line = Math.min(t - 1, Math.floor(answer / a));
				cost += (n - t) * answer;
				cost += (t - line - 1) * answer;
				cost += Math.floor(line * (line + 1) / 2) * a;
				cost /= n;
				answer = cost;
			}
			if (s <= t) {
				answer = Math.min((t - s) * a, answer);
			}
			System.out.println(answer);
		}
	}
}
