package abc.abc201_250.abc248;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/16160 の実装<br/>
 * https://atcoder.jp/contests/abc248/submissions/73429624 にも参考
 */
public class ProblemD別回答3 {

	private static final int B_SIZE = 700;
	private static final int N = 300;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(_ -> scanner.nextInt() - 1).toArray();
			int[][] count = new int[n][N];
			IntStream.range(0, n).forEach(i -> Arrays.fill(count[i], 0));
			IntStream.range(0, n).forEach(i -> count[a[i]][i / B_SIZE]++);
			int q = scanner.nextInt();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int l = scanner.nextInt() - 1, r = scanner.nextInt(), x = scanner.nextInt() - 1, answer = 0;
				while (l < r) {
					if ((0 == l % B_SIZE) && (l + B_SIZE <= r)) {
						answer += count[x][l / B_SIZE];
						l += B_SIZE;
					} else {
						answer += (a[l] == x) ? 1 : 0;
						l++;
					}
				}
				sb.append(answer).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
