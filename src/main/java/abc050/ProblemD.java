package abc050;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc050/submissions/2589569 を参考に作成
 */
public class ProblemD {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			System.out.println(rec(n, n, new HashMap<>()));
		}
	}

	private static long rec(long x, long s, Map<List<Long>, Long> map) {
		if (s == 0L) {
			return 1L;
		}
		List<Long> key = Arrays.asList(x, s);
		Long result = map.get(key);
		if (null != result) {
			return result;
		} else {
			result = (rec(x / 2, s / 2, map) + rec((x - 1) / 2, (s - 1) / 2, map)
					+ ((s >= 2L) ? rec(x / 2, (s - 2) / 2, map) : 0L)) % MOD;
			map.put(key, result);
			return result;
		}
	}
}
