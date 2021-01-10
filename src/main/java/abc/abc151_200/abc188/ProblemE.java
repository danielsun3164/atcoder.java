package abc.abc151_200.abc188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> childrens[scanner.nextInt() - 1].add(scanner.nextInt() - 1));
			/** max[i]はi番目の町からかった金の売れる最高値 */
			int[] max = new int[n];
			Arrays.fill(max, -INF);
			IntStream.range(0, n).forEach(i -> {
				if (-INF == max[i]) {
					calcMax(i, a, max, childrens);
				}
			});
			System.out.println(IntStream.range(0, n).map(i -> max[i] - a[i]).max().getAsInt());
		}
	}

	/**
	 * 現在の町で買った金が売れる最高値を計算する
	 * 
	 * @param now       現在の計算対象の町
	 * @param a         各町の金の値段の配列
	 * @param max       各町で買った金が売れる最高値の配列
	 * @param childrens 次へ行ける町の配列
	 */
	private static void calcMax(int now, final int[] a, int[] max, final List<Integer>[] childrens) {
		int maxNow = -INF;
		for (int next : childrens[now]) {
			if (-INF == max[next]) {
				// nextが未計算なら、計算する
				calcMax(next, a, max, childrens);
			}
			maxNow = Math.max(maxNow, max[next]);
			maxNow = Math.max(maxNow, a[next]);
		}
		max[now] = maxNow;
	}
}
