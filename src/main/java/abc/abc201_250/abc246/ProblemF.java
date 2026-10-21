package abc.abc201_250.abc246;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3703 の実装
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 英文字の文字数 */
	private static final int N = 26;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), l = scanner.nextInt();
			int[] v = IntStream.range(0, n)
					.map(i -> scanner.next().chars().map(c -> 1 << (c - 'a')).reduce(0, (s, si) -> s | si)).toArray();
			long answer = 0L;
			for (int i = 1; i < (1 << n); i++) {
				int ch = (1 << N) - 1;
				for (int j = 0; j < n; j++) {
					if (0 != (i & (1 << j))) {
						ch &= v[j];
					}
				}
				int pc = Integer.bitCount(ch);
				answer = (answer + ((1 == (1 & Integer.bitCount(i))) ? powMod(pc, l) : MOD - powMod(pc, l))) % MOD;
			}
			System.out.println(answer);
		}
	}

	/**
	 * n^m mod MOD を計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1L == (1L & m)) {
				result = result * n % MOD;
			}
			n = n * n % MOD;
			m >>= 1;
		}
		return result;
	}
}
