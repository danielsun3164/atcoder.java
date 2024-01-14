package abc.abc201_250.abc221;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 順列のループは https://maku77.github.io/java/numstr/permutation.html を参考
 */
public class ProblemC {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;
	/** 10 */
	private static final int TEN = 10;
	/** 0 */
	private static final char ZERO = '0';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] n = scanner.next().toCharArray();
			System.out.println(permutation(n));
		}
	}

	/**
	 * 与えられた配列で順列のループを実施し、計算結果の最大値を返す
	 *
	 * @param seed 順列のもととなる配列
	 * @return 計算結果の最大値
	 */
	private static long permutation(char[] seed) {
		char[] perm = new char[seed.length];
		boolean[] used = new boolean[seed.length];
		return buildPerm(seed, perm, used, 0);
	}

	/**
	 * 与えられた配列で順列のループを実施し、最大値を計算する
	 *
	 * @param seed  順列のもととなる配列
	 * @param perm  作成された順列
	 * @param used  個々の要素が使用したかどうかを記録用配列
	 * @param index 現在処理しているインデックス
	 * @return 最大値
	 */
	private static long buildPerm(char[] seed, char[] perm, boolean[] used, int index) {
		if (seed.length == index) {
			return procPerm(perm);
		}

		long max = -INF;
		for (int i = 0; i < seed.length; ++i) {
			if (!used[i]) {
				perm[index] = seed[i];
				used[i] = true;
				max = Math.max(max, buildPerm(seed, perm, used, index + 1));
				used[i] = false;
			}
		}
		return max;
	}

	/**
	 * できた順列に対して、コストを計算する
	 *
	 * @param perm 順列
	 * @return 順列を2つの数字に分けて、積の最大値
	 */
	private static long procPerm(char[] perm) {
		if (ZERO != perm[0]) {
			return IntStream.range(1, perm.length).filter(i -> ZERO != perm[i])
					.mapToLong(i -> toLong(perm, 0, i) * toLong(perm, i, perm.length)).max().orElse(-INF);
		}
		return -INF;
	}

	/**
	 * 順列の開始インデックスから終了インデックス（含まない）までの文字列を数値へ変換する
	 *
	 * @param perm  順列
	 * @param start 開始インデックス
	 * @param end   終了インデックス（含まない）
	 * @return 変換された数値
	 */
	private static long toLong(char[] perm, int start, int end) {
		long result = 0L;
		for (int i = start; i < end; i++) {
			result = result * TEN + (perm[i] - ZERO);
		}
		return result;
	}
}
