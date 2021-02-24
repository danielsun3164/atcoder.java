package abc.abc151_200.abc191;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 小数を整数に変換するための倍数 */
	private static final long N = 10_000L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long x = new BigDecimal(scanner.next()).multiply(BigDecimal.valueOf(N)).longValue();
			long y = new BigDecimal(scanner.next()).multiply(BigDecimal.valueOf(N)).longValue();
			long r = new BigDecimal(scanner.next()).multiply(BigDecimal.valueOf(N)).longValue();
			long answer = 0L;
			for (long i = ceil(x - r); i <= x + r; i += N) {
				long ny = sqrt(r * r - (i - x) * (i - x));
				answer += (floor(y + ny) - ceil(y - ny)) / N + 1L;
			}
			System.out.println(answer);
		}
	}

	/**
	 * nを整数にceilする
	 * 
	 * @param n N倍した小数
	 * @return nをceilした整数のN倍
	 */
	private static long ceil(long n) {
		return (n >= 0) ? (n + N - 1) / N * N : -floor(-n);
	}

	/**
	 * nを整数にfloorする
	 * 
	 * @param n N倍した小数
	 * @return nをfloorした整数のN倍
	 */
	private static long floor(long n) {
		return (n >= 0) ? n / N * N : -ceil(-n);
	}

	/**
	 * nの平方のfloorを計算する
	 * 
	 * @param n
	 * @return nの平方のfloor
	 */
	private static long sqrt(long n) {
		long left = 0L, right = Integer.MAX_VALUE >> 1;
		while (right - 1L > left) {
			long med = (left + right) / 2L;
			if (med * med <= n) {
				left = med;
			} else {
				right = med;
			}
		}
		return left;
	}
}
