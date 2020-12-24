package abc.abc101_150.abc128;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] s = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long max = 0L;
			for (int c = 1; c < n - 1; c++) {
				// indexを保存する用
				Set<Integer> set = new HashSet<>();
				long sum = 0L;
				for (int k = 1; k * c < n - 1; k++) {
					// n-1-k*c<=c の条件は https://atcoder.jp/contests/abc128/submissions/14461827 に参考
					if ((n - 1 - k * c <= c) || set.contains(n - 1 - k * c) || set.contains(k * c)
							|| n - 1 - k * c == k * c) {
						break;
					}
					sum = sum + s[n - 1 - k * c] + s[k * c];
					max = Math.max(max, sum);
					set.add(n - 1 - k * c);
					set.add(k * c);
				}
			}
			System.out.println(max);
		}
	}
}
