package abc.abc201_250.abc228;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/2944 の解法2の実装<br/>
 * https://atcoder.jp/contests/abc228/submissions/27341570 にも参考
 */
public class ProblemD別回答1 {

	/** 2^20 */
	private static final int N = 1 << 20;
	/** マスク */
	private static final int MASK = N - 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			long[] a = new long[N];
			Arrays.fill(a, -1L);
			int[] parent = IntStream.range(0, N).toArray();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt();
				long x = scanner.nextLong();
				if (1 == t) {
					int key = find(parent, (int) (x & MASK));
					a[key] = x;
					parent[key] = find(parent, (key + 1) & MASK);
				} else {
					sb.append(a[(int) (x & MASK)]).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * a[x]が-1となるx以上の最小値を返す
	 *
	 * @param parent
	 * @param x
	 * @return a[x]が-1となるx以上の最小値
	 */
	private static int find(int[] parent, int x) {
		return (x == parent[x]) ? x : (parent[x] = find(parent, parent[x]));
	}
}
