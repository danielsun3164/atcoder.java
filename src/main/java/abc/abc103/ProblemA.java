package abc.abc103;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 順列のループは https://maku77.github.io/java/numstr/permutation.html を参考
 */
public class ProblemA {

	/** 数字の数 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] a = IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();
			System.out.println(permutation(a));
		}
	}

	/**
	 * 与えられた配列で順列のループを実施する
	 * 
	 * @param seed 順列のもととなる配列
	 */
	private static int permutation(int[] seed) {
		int[] perm = new int[seed.length];
		boolean[] used = new boolean[seed.length];
		return buildPerm(seed, perm, used, 0);
	}

	/**
	 * 与えられた配列で順列のループを実施し、最小値を計算する
	 * 
	 * @param seed  順列のもととなる配列
	 * @param perm  作成された順列
	 * @param used  個々の要素が使用したかどうかを記録用配列
	 * @param index 現在処理しているインデックス
	 */
	private static int buildPerm(int[] seed, int[] perm, boolean[] used, int index) {
		if (seed.length == index) {
			return procPerm(perm);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < seed.length; ++i) {
			if (!used[i]) {
				perm[index] = seed[i];
				used[i] = true;
				min = Math.min(min, buildPerm(seed, perm, used, index + 1));
				used[i] = false;
			}
		}
		return min;
	}

	/**
	 * できた順列に対して、コストを計算する
	 * 
	 * @param perm 順列
	 * @return コスト
	 */
	private static int procPerm(int[] perm) {
		return IntStream.range(1, perm.length).map(i -> Math.abs(perm[i] - perm[i - 1])).sum();
	}
}
