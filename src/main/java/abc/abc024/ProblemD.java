package abc.abc024;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 1,000,000,007 */
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextInt();
			long b = scanner.nextInt();
			long c = scanner.nextInt();
			long inverse = modpow(getMod(getMod(getMod(b + c) * a) - getMod(b * c)), MOD - 2);
			long r = getMod(getMod((b - a) * c) * inverse);
			long k = getMod(getMod((c - a) * b) * inverse);
			System.out.println(r + " " + k);
		}
	}

	/**
	 * @param l
	 * @param m
	 * @return lのm乗 %MOD
	 */
	private static long modpow(long l, long m) {
		long temp = l;
		long result = 1L;
		while (m > 0) {
			if (1 == (m & 1)) {
				result = getMod(result * temp);
			}
			temp = getMod(temp * temp);
			m >>= 1;
		}
		return result;
	}

	/**
	 * https://atcoder.jp/contests/abc024/submissions/1497639 を参考に作成
	 * 
	 * @param l
	 * @return l%MOD、lが負の数のとき、正の数へ変換
	 */
	private static long getMod(long l) {
		if (l < 0) {
			return MOD + l % MOD;
		} else {
			return l % MOD;
		}
	}
}
