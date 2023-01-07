package other.typical90;

import java.util.Scanner;

public class Problem085 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long k = scanner.nextLong(), answer = 0L;
			for (long a = 1; a * a * a <= k; a++) {
				if (0L == k % a) {
					answer += calc(k / a, a);
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * 整数nがaより大きい2つのb,cの積となるb,cの組の数を計算する
	 *
	 * @param n 整数
	 * @param a bとcの最小値
	 * @return 整数nがaより大きい2つのb,cの積となるb,cの組の数
	 */
	private static long calc(long n, long a) {
		long result = 0L;
		for (long b = a; b * b <= n; b++) {
			if (0L == n % b) {
				result++;
			}
		}
		return result;
	}
}
