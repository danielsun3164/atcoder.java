package other.joi2007ho;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説の解法3を実装したソースコード
 * 
 * https://atcoder.jp/contests/joi2007ho/submissions/4245405 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			// 各チームの負けた回数
			int[] a = new int[n];
			Arrays.fill(a, 0);
			// 各チームが勝ったチームの数
			int[] wCounts = new int[n];
			Arrays.fill(wCounts, 0);
			// 各試合の勝ったチームと負けたチーム
			int[] w = new int[m], l = new int[m];
			IntStream.range(0, m).forEach(i -> {
				w[i] = scanner.nextInt() - 1;
				l[i] = scanner.nextInt() - 1;
				a[l[i]]++;
				wCounts[w[i]]++;
			});
			// 各チームが勝ったチームの一覧
			int[][] dp = new int[n][];
			IntStream.range(0, n).forEach(i -> dp[i] = new int[wCounts[i]]);
			IntStream.range(0, m).forEach(i -> dp[w[i]][--wCounts[w[i]]] = l[i]);
			// 処理済のチームを保存するセット（contains判定用）
			Set<Integer> finishedSet = new HashSet<>();
			// 処理対象のチームの配列
			int[] q = new int[n];
			int start = 0, end = 0, multiResults = 0;
			if ((start == end) && (end < n)) {
				for (int i = 0; i < n; i++) {
					if (0 == a[i]) {
						q[end++] = i;
					}
				}
			}
			if (end > 1) {
				multiResults = 1;
			}
			for (; start < end; start++) {
				System.out.println(q[start] + 1);
				finishedSet.add(q[start]);
				int count = 0;
				for (int lj : dp[q[start]]) {
					if (!finishedSet.contains(lj)) {
						if (0 == (--a[lj])) {
							q[end++] = lj;
							count++;
						}
					}
				}
				if (count > 1) {
					multiResults = 1;
				}
			}
			System.out.println(multiResults);
		}
	}
}
