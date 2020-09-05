package abc.abc115;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			long[] sum = new long[n + 1], patty = new long[n + 1];
			sum[0] = patty[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> {
				sum[i] = (sum[i - 1] << 1) + 3;
				patty[i] = (patty[i - 1] << 1) + 1;
			});
			System.out.println(getResult(n, k, sum, patty));
		}
	}

	/**
	 * パティは何枚あるかを計算する
	 * 
	 * @param n
	 * @param k
	 * @param sum   階層数の配列
	 * @param patty バティ総数の配列
	 * @return パティは何枚あるか
	 */
	private static long getResult(int n, long k, long[] sum, long[] patty) {
		if (k <= n) {
			// パティまで食べられない
			return 0L;
		} else if (k >= sum[n] - n) {
			// パティをすべて食べた場合
			return patty[n];
		} else if (k <= sum[n - 1] + 1) {
			// 前半までしか食べない場合
			return getResult(n - 1, k - 1, sum, patty);
		} else if (k == sum[n - 1] + 2) {
			// 前半＋真ん中のパティを食べる場合
			return patty[n - 1] + 1;
		} else {
			// 後半まで食べる場合
			return patty[n] - getResult(n - 1, sum[n] - k - 1, sum, patty);
		}
	}
}
