package abc.abc201_250.abc231;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc231/editorial/3062 の解説の実装<br/>
 * https://atcoder.jp/contests/abc231/submissions/27854173 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long x = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			System.out.println(calc(a, x, 0, new HashMap<>()));
		}
	}

	/**
	 * x円を硬貨で支払う場合の最低硬貨の数を計算する
	 *
	 * @param a   硬貨の配列
	 * @param x   支払う金額
	 * @param beg 使う硬貨の種類
	 * @param map 計算結果を保存するマップ
	 * @return x円を硬貨で支払う場合の最低硬貨の数
	 */
	private static long calc(long[] a, long x, int beg, Map<Long, Long> map) {
		if (map.containsKey(x)) {
			return map.get(x);
		}
		if (beg == a.length - 1) {
			return x / a[a.length - 1];
		}
		if (0L == x) {
			map.put(x, 0L);
			return 0L;
		}
		long current = a[beg], next = a[beg + 1];
		long r = x % next / current;
		long result = calc(a, x / next * next, beg + 1, map) + r;
		if (r > 0L) {
			result = Math.min(result, calc(a, (x + next - 1) / next * next, beg + 1, map) + next / current - r);
		}
		map.put(x, result);
		return result;
	}
}
