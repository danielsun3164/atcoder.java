package abc.abc151_200.abc195;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 青木さんを表す文字 */
	private static final char AOKI = 'A';
	/** mod計算の数字 */
	private static final int N = 7;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] cs = scanner.next().toCharArray(), t = scanner.next().toCharArray();
			// 文字から数字へ変換
			int[] s = IntStream.range(0, n).map(i -> cs[i] - '0').toArray();
			@SuppressWarnings("unchecked")
			Set<Integer>[] dp = new Set[2];
			dp[n & 1] = Set.of(0);
			for (int i = n - 1; i >= 0; i--) {
				dp[i & 1] = new HashSet<>();
				for (int r = 0; r < N; r++) {
					if (AOKI == t[i]) {
						if (dp[(i + 1) & 1].contains((10 * r) % N) && dp[(i + 1) & 1].contains((10 * r + s[i]) % N)) {
							dp[i & 1].add(r);
						}
					} else {
						if (dp[(i + 1) & 1].contains((10 * r) % N) || dp[(i + 1) & 1].contains((10 * r + s[i]) % N)) {
							dp[i & 1].add(r);
						}
					}
				}
			}
			System.out.println((dp[0].contains(0)) ? "Takahashi" : "Aoki");
		}
	}
}
