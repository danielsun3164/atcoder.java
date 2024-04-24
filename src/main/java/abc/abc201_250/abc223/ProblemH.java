package abc.abc201_250.abc223;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc223/editorial/2784 の解説の実装<br/>
 * https://atcoder.jp/contests/abc223/submissions/26990597 にも参考
 */
public class ProblemH {

	/** 数字の２進数桁数 */
	private static final int N = 60;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			@SuppressWarnings("unchecked")
			List<Query>[] queries = new List[n];
			IntStream.range(0, n).forEach(i -> queries[i] = new ArrayList<>());
			IntStream.range(0, q).forEach(i -> {
				int l = scanner.nextInt() - 1, r = scanner.nextInt() - 1;
				long x = scanner.nextLong();
				queries[r].add(new Query(l, i, x));
			});
			Base[] bases = IntStream.range(0, N).mapToObj(i -> new Base(1L << i, -1)).toArray(Base[]::new);
			boolean[] answers = new boolean[q];
			for (int i = 0; i < n; i++) {
				Base add = new Base(a[i], i);
				for (int j = N - 1; j >= 0; j--) {
					if (0L != ((add.x >> j) & 1L)) {
						if (bases[j].index < add.index) {
							Base tmp = bases[j];
							bases[j] = add;
							add = tmp;
						}
						add.x ^= bases[j].x;
					}
				}
				for (Query query : queries[i]) {
					long b = query.x;
					for (int j = N - 1; j >= 0; j--) {
						if ((0L != ((b >> j) & 1L)) && (bases[j].index >= query.from)) {
							b ^= bases[j].x;
						}
					}
					answers[query.index] = (0L == b);
				}
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> sb.append(answers[i] ? "Yes" : "No").append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * from, index, xを格納するクラス
	 */
	private static class Query {
		int from, index;
		long x;

		Query(int from, int index, long x) {
			super();
			this.from = from;
			this.index = index;
			this.x = x;
		}
	}

	/**
	 * x, indexを格納するクラス
	 */
	private static class Base {
		long x;
		int index;

		Base(long x, int index) {
			super();
			this.x = x;
			this.index = index;
		}
	}
}
