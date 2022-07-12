package abc.abc151_200.abc184;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * O(2^{N/2})の実装<br/>
 * https://atcoder.jp/contests/abc184/submissions/18301551 にも参照
 */
public class ProblemF別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long t = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[][] bc = new long[2][1];
			bc[0][0] = bc[1][0] = 0L;
			IntStream.range(0, n).forEach(i -> bc[i & 1] = merge(bc[i & 1], a[i]));
			int bIndex = bc[0].length - 1;
			long answer = 0L;
			for (long x : bc[1]) {
				if (x > t) {
					break;
				}
				while (x + bc[0][bIndex] > t) {
					bIndex--;
				}
				answer = Math.max(answer, x + bc[0][bIndex]);
			}
			System.out.println(answer);
		}
	}

	/**
	 * aの一覧とa+xの一覧を一つの配列にマージする
	 *
	 * @param a 配列
	 * @param x 追加する数値
	 * @return マージされた配列
	 */
	private static long[] merge(long[] a, long x) {
		long[] result = new long[a.length << 1];
		int rIndex = 0, aIndex = 0;
		for (long ai : a) {
			while (x + a[aIndex] < ai) {
				result[rIndex++] = x + a[aIndex++];
			}
			result[rIndex++] = ai;
		}
		while (aIndex < a.length) {
			result[rIndex++] = x + a[aIndex++];
		}
		return result;
	}
}
