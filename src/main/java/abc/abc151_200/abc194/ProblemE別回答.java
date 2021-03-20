package abc.abc151_200.abc194;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc194/submissions/20728200 にも参考
 */
public class ProblemE別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// pre[ai]はaiが前回出現したindex、interval[ai]=はaiのindexの間隔（末尾を含まない）の最大値、
			// result[ai]はaiのindexの間隔（末尾を含む）の最小値
			int[] pre = new int[n], interval = new int[n], result = new int[n];
			Arrays.fill(pre, -1);
			Arrays.fill(interval, 0);
			Arrays.fill(result, n);
			IntStream.range(0, n).forEach(i -> {
				interval[a[i]] = Math.max(interval[a[i]], i - pre[a[i]] - 1);
				result[a[i]] = Math.min(result[a[i]], Math.max(interval[a[i]], n - i - 1));
				pre[a[i]] = i;
			});
			System.out.println(IntStream.range(0, n).filter(i -> result[i] >= m).findFirst().orElse(n));
		}
	}
}
