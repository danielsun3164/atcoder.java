package abc.abc201_250.abc221;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemF {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	/** 5 */
	private static int N = 5;

	// TLE対応のため、メソッド呼び出し用の変数をstaticメンバー変数にする
	private static int index, num, blc, count;
	private static int[][] edges, d;
	private static int[] mx = new int[N], mv = new int[N];

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			calcEdges(scanner, n);
			d = new int[n][N];
			IntStream.range(0, n).forEach(i -> Arrays.fill(d[i], -1));
			Arrays.fill(mx, -1);
			Arrays.fill(mx, 0);
			count = 0;
			index = 0;
			num = 0;
			blc = -1;
			dfs(0, -1);
			index = 1;
			dfs(mv[0], -1);
			index = 2;
			dfs(mv[1], -1);
			List<Integer> a = new ArrayList<>();
			if (1 == (mx[1] & 1)) {
				int u = IntStream.range(0, n).map(i -> n - 1 - i)
						.filter(i -> (d[i][1] == (mx[1] >> 1)) && (d[i][2] == (mx[1] >> 1) + 1)).findFirst().getAsInt();
				int v = IntStream.range(0, n).map(i -> n - 1 - i)
						.filter(i -> (d[i][2] == (mx[1] >> 1)) && (d[i][1] == (mx[1] >> 1) + 1)).findFirst().getAsInt();
				index = 3;
				num = mx[1] >> 1;
				blc = v;
				count = 0;
				dfs(u, -1);
				a.add(count);
				blc = u;
				count = 0;
				dfs(v, -1);
				a.add(count);
			} else {
				int u = IntStream.range(0, n).map(i -> n - 1 - i)
						.filter(i -> (d[i][1] == (mx[1] >> 1)) && (d[i][2] == (mx[1] >> 1))).findFirst().getAsInt();
				index = 3;
				num = (mx[1] >> 1) - 1;
				blc = u;
				for (int next : edges[u]) {
					count = 0;
					dfs(next, -1);
					a.add(count);
				}
			}
			long answer = 1L;
			for (int ai : a) {
				answer = answer * (ai + 1) % MOD;
			}
			for (int ai : a) {
				answer = (answer + MOD - ai) % MOD;
			}
			answer = (answer + MOD - 1) % MOD;
			System.out.println(answer);
		}
	}

	/**
	 * 辺の配列を計算する<br/>
	 * TLE対応のため、辺はList<Integer>[]ではなく、int[][]にする
	 *
	 * @param scanner
	 * @param n
	 */
	private static void calcEdges(Scanner scanner, int n) {
		int[] u = new int[n - 1], v = new int[n - 1], counts = new int[n];
		Arrays.fill(counts, 0);
		IntStream.range(0, n - 1).forEach(i -> {
			u[i] = scanner.nextInt() - 1;
			v[i] = scanner.nextInt() - 1;
			counts[u[i]]++;
			counts[v[i]]++;
		});
		edges = new int[n][];
		IntStream.range(0, n).forEach(i -> edges[i] = new int[counts[i]]);
		IntStream.range(0, n - 1).forEach(i -> {
			edges[u[i]][--counts[u[i]]] = v[i];
			edges[v[i]][--counts[v[i]]] = u[i];
		});
	}

	private static void dfs(int now, int prev) {
		d[now][index] = (-1 == prev) ? 0 : (d[prev][index] + 1);
		if (mx[index] < d[now][index]) {
			mx[index] = d[now][index];
			mv[index] = now;
		}
		if (num == d[now][index]) {
			count++;
		}
		for (int next : edges[now]) {
			if ((blc != next) && (d[next][index] < 0)) {
				dfs(next, now);
			}
		}
	}
}
