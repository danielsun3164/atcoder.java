package abc.abc151_200.abc196;

import java.util.Scanner;

public class ProblemC {

	/** 倍数となる基数一覧 */
	private static final long[] KEYS = { 11, 101, 1001, 10001, 100001, 1000001 };
	/** 条件を見なす数字の最小値の一覧 */
	private static final long[] MINS = { 11, 1010, 100100, 10001000, 1000010000L, 100000100000L };
	/** 条件を見なす数字の最大値の一覧 */
	private static final long[] MAXS = { 99, 9999, 999999, 99999999, 9999999999L, 999999999999L };
	/** それぞれ条件を見なす数字の数 */
	private static final int[] RESULTS = { 9, 90, 900, 9000, 90000, 900000 };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), answer = 0L;
			for (int i = 0; i < KEYS.length; i++) {
				if (n < MINS[i]) {
					break;
				}
				if (n > MAXS[i]) {
					answer += RESULTS[i];
				} else {
					answer += (n - MINS[i]) / KEYS[i] + 1;
				}
			}
			System.out.println(answer);
		}
	}
}
