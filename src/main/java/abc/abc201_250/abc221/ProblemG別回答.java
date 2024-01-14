package abc.abc201_250.abc221;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc221/editorial/2741 の実装<br/>
 * https://atcoder.jp/contests/abc221/submissions/26323758 にも参考
 */
public class ProblemG別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			int[] d = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int x = a + b, y = a - b;
			int sum = Arrays.stream(d).sum();
			if ((Math.abs(x) > Math.abs(sum)) || (Math.abs(y) > Math.abs(sum)) || (((x + sum) & 1) != 0)
					|| (((y + sum) & 1) != 0)) {
				System.out.println("No");
				return;
			}
			boolean[] solA = subsetSum(d, (sum + x) >> 1), solB = subsetSum(d, (sum + y) >> 1);
			if ((0 == solA.length) || (0 == solB.length)) {
				System.out.println("No");
				return;
			}
			System.out.println("Yes");
			StringBuilder answer = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (solA[i]) {
					answer.append(solB[i] ? 'R' : 'U');
				} else {
					answer.append(solB[i] ? 'D' : 'L');
				}
			}
			System.out.println(answer.toString());
		}
	}

	/**
	 * subset sumを計算する
	 *
	 * @param a      配列
	 * @param target 目標値
	 * @return subset sumの配列
	 */
	private static boolean[] subsetSum(int[] a, int target) {
		int n = a.length, aMax = Arrays.stream(a).max().getAsInt(), index = 0, sum = 0;
		while ((index < n) && (sum + a[index] <= target)) {
			sum += a[index];
			index++;
		}
		if ((index == n) && (sum != target)) {
			return new boolean[] {};
		}
		int[] dp = new int[aMax << 1];
		Arrays.fill(dp, -1);
		int[][] prv = new int[n][aMax << 1];
		IntStream.range(0, n).forEach(i -> Arrays.fill(prv[i], -1));
		int offset = target - aMax + 1;
		dp[sum - offset] = index;
		for (int i = index; i < n; i++) {
			int[] dp2 = new int[aMax << 1];
			System.arraycopy(dp, 0, dp2, 0, dp.length);
			for (int j = aMax - 1; j >= 0; j--) {
				if (dp2[j + a[i]] < dp2[j]) {
					prv[i][j + a[i]] = -2;
					dp2[j + a[i]] = dp2[j];
				}
			}
			for (int j = aMax * 2 - 1; j >= aMax; j--) {
				for (int k = dp2[j] - 1; k >= Math.max(dp[j], 0); k--) {
					if (dp2[j - a[k]] < k) {
						prv[i][j - a[k]] = k;
						dp2[j - a[k]] = k;
					}
				}
			}
			dp = dp2;
		}
		if (-1 == dp[aMax - 1]) {
			return new boolean[] {};
		}
		boolean[] answer = new boolean[n];
		Arrays.fill(answer, false);
		int i = n - 1, j = aMax - 1;
		while (i >= index) {
			int p = prv[i][j];
			if (-2 == p) {
				answer[i] = !answer[i];
				j -= a[i];
				i--;
			} else if (-1 == p) {
				i--;
			} else {
				answer[p] = !answer[p];
				j += a[p];
			}
		}
		while (i >= 0) {
			answer[i] = !answer[i];
			i--;
		}
		return answer;
	}
}
