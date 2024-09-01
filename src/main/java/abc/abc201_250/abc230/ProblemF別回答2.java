package abc.abc201_250.abc230;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc230/editorial/3082 の実装<br/>
 * https://atcoder.jp/contests/abc230/submissions/27657533 にも参考
 */
public class ProblemF別回答2 {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] s = new long[n];
			IntStream.range(0, n).forEach(i -> s[i] = ((i > 0) ? s[i - 1] : 0L) + scanner.nextLong());
			NavigableSet<Long> set = IntStream.range(0, n - 1).mapToLong(i -> s[i]).boxed()
					.collect(Collectors.toCollection(TreeSet::new));
			NavigableMap<Long, Integer> map = new TreeMap<>();
			int index = 0;
			for (long seti : set) {
				map.put(seti, index++);
			}
			int m = set.size();
			int[] a = IntStream.range(0, n).map(i -> {
				Long higher = set.higher(s[i]);
				return (null == higher) ? m - 1 : map.get(higher) - 1;
			}).toArray();
			long[] dp = new long[m];
			Arrays.fill(dp, 0L);
			long answer = 1L;
			for (int i = 0; i < n - 1; i++) {
				long temp = answer;
				answer = ((answer << 1) - dp[a[i]] + MOD) % MOD;
				dp[a[i]] = temp;
			}
			System.out.println(answer);
		}
	}
}
