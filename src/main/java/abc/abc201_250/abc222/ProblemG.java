package abc.abc201_250.abc222;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc222/editorial/2750 の解の候補を絞り全探索する実装
 */
public class ProblemG {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			while (t-- > 0) {
				int k = scanner.nextInt();
				System.out.println(solve(k));
			}
		}
	}

	/**
	 * mの計算結果を計算する
	 *
	 * @param m
	 * @return mの計算結果
	 */
	private static int solve(int m) {
		if (0 == (1 & m)) {
			m >>= 1;
		}
		m *= 9;
		for (int d : divisor(phi(m))) {
			if (1 == pow(TEN, d, m)) {
				return d;
			}
		}
		return -1;
	}

	/**
	 * nの約数一覧を計算する
	 *
	 * @param n
	 * @return nの約数一覧
	 */
	private static int[] divisor(int n) {
		List<Integer> list = new ArrayList<>();
		for (int d = 1; d * d <= n; d++) {
			if (0 == n % d) {
				list.add(d);
				if (d != n / d) {
					list.add(n / d);
				}
			}
		}
		return list.stream().sorted().mapToInt(Integer::intValue).toArray();
	}

	/**
	 * nのφ関数を計算する
	 *
	 * @param n
	 * @return nのφ関数
	 */
	private static int phi(int n) {
		int answer = n;
		for (int p = 2; p * p <= n; p++) {
			if (0 == n % p) {
				while (0 == n % p) {
					n /= p;
				}
				answer -= answer / p;
			}
		}
		if (1 != n) {
			answer -= answer / n;
		}
		return answer;
	}

	/**
	 * a ^ n % m を計算する
	 *
	 * @param a
	 * @param n
	 * @param m
	 * @return a ^ n % m
	 */
	private static int pow(long a, int n, int m) {
		long answer = 1L;
		a %= m;
		while (n > 0) {
			if (1 == (1 & n)) {
				answer = answer * a % m;
			}
			a = a * a % m;
			n >>= 1;
		}
		return (int) answer;
	}
}
