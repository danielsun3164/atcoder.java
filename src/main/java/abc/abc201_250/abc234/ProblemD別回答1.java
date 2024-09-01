package abc.abc201_250.abc234;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc234/editorial/3241 の実装
 */
public class ProblemD別回答1 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] p = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			boolean[] a = new boolean[n];
			Arrays.fill(a, false);
			int x = IntStream.range(0, k).map(i -> {
				a[p[i]] = true;
				return p[i];
			}).min().getAsInt();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			sb.append(x + 1).append(System.lineSeparator());
			for (int i = k; i < n; i++) {
				if (p[i] > x) {
					a[x] = false;
					a[p[i]] = true;
				}
				while (!a[x]) {
					x++;
				}
				sb.append(x + 1).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
