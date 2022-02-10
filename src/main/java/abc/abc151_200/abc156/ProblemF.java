package abc.abc151_200.abc156;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc156/submissions/10318264 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt(), q = scanner.nextInt();
			int[] d = IntStream.range(0, k).map(i -> scanner.nextInt()).toArray();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(t -> {
				int n = scanner.nextInt() - 1, x = scanner.nextInt(), m = scanner.nextInt();
				int[] dm = new int[k];
				long tot = IntStream.range(0, k).mapToLong(i -> dm[i] = (0 == d[i] % m) ? m : d[i] % m).sum();
				x %= m;
				long start = x, end = x + n / k * tot + IntStream.range(0, n % k).mapToLong(i -> dm[i]).sum();
				sb.append(n - (end / m - start / m)).append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
