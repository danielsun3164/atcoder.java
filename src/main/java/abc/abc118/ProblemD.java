package abc.abc118;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	/** 数字を作るのに必要なマッチ数 */
	private static final int[] NUMBERS = { 0, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, m).map(i -> scanner.nextInt()).sorted().toArray();
			int[] num = IntStream.range(0, m).map(i -> num(a[i])).sorted().toArray();
			int digit = dp(n, num), remain = n;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digit; i++) {
				for (int j = m - 1; j >= 0; j--) {
					if (dp(remain - num(a[j]), num) == dp(remain, num) - 1) {
						sb.append(a[j]);
						remain -= num(a[j]);
						break;
					}
				}
			}
			System.out.println(sb.toString());
		}
	}

	/**
	 * @param k 数字
	 * @return 数字を並べるのに必要なマッチ棒の数
	 */
	private static int num(int k) {
		return NUMBERS[k];
	}

	/**
	 * @param n   マッチ棒の総数
	 * @param num 数字を並べるのに必要なマッチ棒の数一覧
	 * @return 並べられる最大桁数
	 */
	private static int dp(int n, int[] num) {
		if (0 == n) {
			return 0;
		}
		int min = num[0];
		if (n % min == 0) {
			return n / min;
		} else {
			for (int number : num) {
				if (n >= number) {
					int next = dp(n - number, num);
					if (next >= 0) {
						return next + 1;
					}
				}
			}
		}
		return -1;
	}
}
