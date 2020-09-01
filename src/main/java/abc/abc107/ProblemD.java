package abc.abc107;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc107/submissions/14509241 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int right = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).max().getAsInt();
			int left = Arrays.stream(a).min().getAsInt();
			long mLength = n * (n + 1L) / 2;
			int answer = -1;
			while (left <= right) {
				int middle = (left + right) / 2;
				if (calcNonLessNumber(a, middle) >= (mLength + 1) / 2) {
					answer = middle;
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			}
			System.out.println(answer);
		}
	}

	/**
	 * a の連続部分列 a[l, r] (1 ≤ l ≤ r ≤ N) のうち，(A の個数) ≤ (B の個数) を満たすものは何通りかを計算する
	 * 
	 * 
	 * @param a     配列
	 * @param value 基準となるvalue
	 * @return a の連続部分列 a[l, r] (1 ≤ l ≤ r ≤ n) のうち，(A の個数) ≤ (B の個数) を満たすものは何通りか
	 */
	private static long calcNonLessNumber(int[] a, int value) {
		int[] sum = new int[a.length + 1];
		sum[0] = 0;
		IntStream.rangeClosed(1, a.length).forEach(i -> sum[i] = sum[i - 1] + ((a[i - 1] >= value) ? 1 : -1));
		return calcNonInversionNumber(sum, 0, sum.length - 1);
	}

	/**
	 * 配列の転倒していない数を計算
	 * 
	 * @param a    配列
	 * @param from 開始インデックス
	 * @param to   終了インデックス
	 * @return 配列の転倒していない数
	 */
	private static long calcNonInversionNumber(int[] a, int from, int to) {
		if (from == to) {
			return 0L;
		}
		int middle = (from + to) / 2;
		long result = calcNonInversionNumber(a, from, middle) + calcNonInversionNumber(a, middle + 1, to);
		int[] sorted = new int[to - from + 1];
		int left = from, right = middle + 1, sortedIndex = 0;
		while ((left != middle + 1) || (right != to + 1)) {
			if ((right == to + 1) || ((left != middle + 1) && (a[left] <= a[right]))) {
				result += to - right + 1;
				sorted[sortedIndex++] = a[left++];
			} else {
				sorted[sortedIndex++] = a[right++];
			}
		}
		IntStream.rangeClosed(from, to).forEach(i -> a[i] = sorted[i - from]);
		return result;
	}
}
