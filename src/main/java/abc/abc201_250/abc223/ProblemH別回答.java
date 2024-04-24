package abc.abc201_250.abc223;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc223/submissions/26603467 を参考に作成
 */
public class ProblemH別回答 {

	/** 数字の２進数桁数 */
	private static final int N = 64;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] base1 = new long[N], base2 = new long[N];
			int[][] index = new int[n + 1][N];
			for (int i = n - 1; i >= 0; i--) {
				long[] used = new long[N + 1];
				int count = 0;
				base2[0] = a[i];
				index[i][0] = i + 1;
				count++;
				used[Long.numberOfTrailingZeros(a[i])] = a[i];
				for (int j = 0; index[i + 1][j] != 0; j++) {
					long vv = base1[j];
					while (0L != (vv & used[Long.numberOfTrailingZeros(vv)])) {
						vv ^= used[Long.numberOfTrailingZeros(vv)];
					}
					if (0L != vv) {
						base2[count] = vv;
						index[i][count] = index[i + 1][j];
						count++;
						used[Long.numberOfTrailingZeros(vv)] = vv;
					}
				}
				long[] temp = base1;
				base1 = base2;
				base2 = temp;
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(qq -> {
				int l = scanner.nextInt() - 1, r = scanner.nextInt() - 1;
				long x = scanner.nextLong();
				long[] base = new long[N];
				int count = 0;
				for (int j = 0; (0 != index[l][j]) && index[l][j] - 1 <= r; j++) {
					long crr = a[index[l][j] - 1];
					for (int i = 0; i < count; i++) {
						crr = Math.min(crr, crr ^ base[i]);
					}
					if (0L != crr) {
						base[count++] = crr;
						x = Math.min(x, x ^ crr);
					}
				}
				sb.append((0L == x) ? "Yes" : "No").append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
