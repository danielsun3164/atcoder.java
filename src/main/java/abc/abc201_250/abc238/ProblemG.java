package abc.abc201_250.abc238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc238/editorial/3358 の実装
 */
public class ProblemG {

	/** 10^6 */
	private static final int MAX = 1_000_000;
	/** 3 */
	private static final int N = 3;

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
			Random random = new Random(System.currentTimeMillis());
			long[][] hs = new long[MAX][N];
			IntStream.range(0, MAX).forEach(i -> {
				hs[i][0] = random.nextLong();
				hs[i][1] = random.nextLong();
				hs[i][2] = hs[i][0] ^ hs[i][1];
			});
			int[] bk = new int[MAX];
			Arrays.fill(bk, 0);
			long[] rw = new long[n + 1];
			Arrays.fill(rw, 0L);
			IntStream.range(0, n).forEach(i -> {
				rw[i + 1] = rw[i];
				factors[a[i]].stream().forEach(nx -> {
					rw[i + 1] ^= hs[nx][bk[nx] % N];
					bk[nx]++;
				});
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q)
					.forEach(i -> sb.append((rw[l[i] - 1] == rw[r[i]]) ? "Yes" : "No").append(System.lineSeparator()));
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
}
