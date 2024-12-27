package other.math_and_algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem089 {

	/** 最大値 */
	private static final long MAX = Long.MAX_VALUE >> 3;
	private static final BigInteger MAX_BG = BigInteger.valueOf(MAX);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong(), c = scanner.nextLong();
			System.out.println((a < pow(c, b)) ? "Yes" : "No");
		}
	}

	/**
	 * n ^ m を計算する
	 *
	 * @param n
	 * @param m
	 * @return n ^ m、ただし、結果が最大値を超えた場合、最大値を返す
	 */
	private static long pow(long n, long m) {
		BigInteger result = BigInteger.ONE, bgN = BigInteger.valueOf(n);
		while (m > 0) {
			if (1L == (1L & m)) {
				result = result.multiply(bgN);
				if (result.compareTo(MAX_BG) > 0) {
					return MAX;
				}
			}
			m >>= 1;
			bgN = bgN.multiply(bgN);
			if ((m > 0) && (bgN.compareTo(MAX_BG) > 0)) {
				return MAX;
			}
		}
		return result.longValue();
	}
}
