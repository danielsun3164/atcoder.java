package abc.abc201_250.abc238;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemC {

	/** 19 */
	private static final int N = 19;
	/** 10 */
	private static final int TEN = 10;
	/** mod対象数字 */
	private static final long MOD = 998_244_353L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long[] maxLongs = maxLongs();
			long n = scanner.nextLong(), answer = 0L;
			int index = 0;
			while (maxLongs[index] < n) {
				long diff = (Math.min(maxLongs[index + 1], n) - maxLongs[index]) % MOD;
				answer = (answer + diff * (diff + 1) % MOD * powMod(2L, MOD - 2)) % MOD;
				index++;
			}
			System.out.println(answer);
		}
	}

	/**
	 * 各桁の最大値の配列を計算する
	 *
	 * @return 各桁の最大値の配列
	 */
	private static long[] maxLongs() {
		List<Long> list = new ArrayList<>();
		long now = 1L;
		for (int i = 0; i < N; i++) {
			list.add(now - 1);
			now *= TEN;
		}
		list.add(Long.MAX_VALUE);
		return list.stream().mapToLong(Long::longValue).toArray();
	}

	/**
	 * n^m mod MODを計算する
	 *
	 * @param n
	 * @param m
	 * @return n^m mod MOD
	 */
	private static long powMod(long n, long m) {
		long result = 1L;
		while (m > 0) {
			if (1 == (1 & m)) {
				result = (result * n) % MOD;
			}
			n = (n * n) % MOD;
			m >>= 1;
		}
		return result;
	}
}
