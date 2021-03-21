package abc.abc151_200.abc196;

import java.util.Scanner;

public class ProblemC {

	/** 倍数となる基数一覧 */
	private static final long[] KEYS = { 11L, 101L, 1_001L, 1_0001L, 1_00001L, 1_000001L };
	/** 条件を見なす数字の最小値の一覧 */
	private static final long[] MINS = { 11L, 10_10L, 100100, 1000_1000L, 10000_10000L, 100000_100000L };
	/** 条件を見なす数字の最大値の一覧 */
	private static final long[] MAXS = { 99L, 99_99L, 999_999L, 9999_9999L, 99999_99999L, 999999_999999L };
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
