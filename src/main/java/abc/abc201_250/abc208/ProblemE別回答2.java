package abc.abc201_250.abc208;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc208/editorial/2225 の解説通りに実装したソースコード
 */
public class ProblemE別回答2 {

	/** 10進数の計算 */
	private static final int N = 10;
	/** 計算結果を保存するマップ */
	private static final Map<List<Long>, Long> map = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), k = scanner.nextLong();
			map.clear();
			System.out.println(a(n, k) - 1);
		}
	}

	/**
	 * n以下の各桁の積がk以下の数字の個数を計算する
	 *
	 * @param n
	 * @param k
	 * @return n以下の各桁の積がk以下の数字の個数
	 */
	private static long a(long n, long k) {
		List<Long> key = Arrays.asList(n, k);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		long result = n / N + IntStream.range(1, (int) Math.min((n + 1), N)).mapToLong(y -> a((n - y) / N, k / y)).sum()
				+ ((k > 0L) ? 1L : 0L);
		map.put(key, result);
		return result;
	}
}
