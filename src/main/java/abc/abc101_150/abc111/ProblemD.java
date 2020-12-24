package abc.abc101_150.abc111;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc111/submissions/3312161 にも参考
 */
public class ProblemD {

	/** モード一覧 */
	private static final char[] MODES = { 'L', 'D', 'U', 'R' };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] u = new int[n], v = new int[n];
			IntStream.range(0, n).forEach(i -> {
				int x = scanner.nextInt(), y = scanner.nextInt();
				u[i] = x + y;
				v[i] = x - y;
			});
			int r = u[0] & 1;
			for (int i = 1; i < n; i++) {
				if (r != (u[i] & 1)) {
					System.out.println("-1");
					return;
				}
			}
			r = 1 - r;
			int m = 31;
			System.out.println(m + r);
			StringBuilder answer = new StringBuilder();
			if (r > 0) {
				answer.append("1").append(" ");
			}
			IntStream.range(0, m).forEach(i -> answer.append(1 << i).append(" "));
			// 最後のスペースを削除
			answer.deleteCharAt(answer.length() - 1);
			System.out.println(answer.toString());

			long base = (1L << m) - 1 - r;
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				if (r > 0) {
					sb.append('R');
				}
				long uBase = (u[i] + base) >> 1, vBase = (v[i] + base) >> 1;
				for (int j = 0; j < m; j++) {
					int u1 = (int) (uBase & 1L) << 1;
					int v1 = (int) (vBase & 1L);
					sb.append(MODES[u1 + v1]);
					uBase >>= 1;
					vBase >>= 1;
				}
				System.out.println(sb.toString());
			}
		}
	}
}
