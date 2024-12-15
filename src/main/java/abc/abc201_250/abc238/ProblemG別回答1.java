package abc.abc201_250.abc238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc238/editorial/3362 の実装
 */
public class ProblemG別回答1 {

	/** 10^6 */
	private static final int MAX = 1_000_000;
	/** 3 */
	private static final int N = 3;
	/**  */
	private static final long M = 88_172_645_463_325_252L;
	private static long x;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] l = new int[q], r = new int[q];
			IntStream.range(0, q).forEach(i -> {
				l[i] = scanner.nextInt();
				r[i] = scanner.nextInt();
			});
			List<Integer>[] factors = calcFactors();
			boolean[] result = new boolean[q];
			Arrays.fill(result, true);
			x = M;
			IntStream.range(0, 20).forEach(tr -> {
				int[] mem = new int[MAX], h = new int[n + 1];
				IntStream.range(0, MAX).forEach(i -> mem[i] = (int) (xor64() % N + N) % N);
				Arrays.fill(h, 0);
				IntStream.range(0, n).forEach(i -> factors[a[i]].forEach(nx -> h[i + 1] += mem[nx]));
				IntStream.rangeClosed(1, n).forEach(i -> h[i] += h[i - 1]);
				IntStream.range(0, q).filter(i -> 0 != (h[r[i]] - h[l[i] - 1]) % N).forEach(i -> result[i] = false);
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> sb.append(result[i] ? "Yes" : "No").append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * MAXまでの数字の因数一覧を計算する
	 *
	 * @return MAXまでの数字の因数一覧
	 */
	private static List<Integer>[] calcFactors() {
		@SuppressWarnings("unchecked")
		List<Integer>[] factors = new List[MAX + 1];
		IntStream.rangeClosed(0, MAX).forEach(i -> factors[i] = new ArrayList<>());
		IntStream.rangeClosed(2, MAX).filter(i -> factors[i].isEmpty())
				.forEach(i -> IntStream.iterate(i, j -> j <= MAX, j -> j + i).forEach(j -> {
					int mj = j;
					while (0 == mj % i) {
						factors[j].add(i);
						mj /= i;
					}
				}));
		return factors;
	}

	/**
	 * xorで64bitの乱数を計算する
	 *
	 * @return 64bitの乱数
	 */
	private static long xor64() {
		x ^= (x << 13);
		x ^= (x >> 7);
		return (x ^= (x << 17));
	}
}
