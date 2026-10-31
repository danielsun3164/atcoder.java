package abc.abc201_250.abc248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc248/editorial/3795 の実装
 */
public class ProblemG {

	/** mod対象数字 */
	private static final long MOD = 998_244_353L;
	private static final int D = 130;
	/** ローカル変数 */
	private static int[] a;
	private static List<Integer>[] edges;
	private static boolean[] used;
	private static long answer;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			a = IntStream.range(0, n).map(_ -> scanner.nextInt()).toArray();
			edges = new List[n];
			IntStream.range(0, n).forEach(i -> edges[i] = new ArrayList<>());
			IntStream.range(0, n - 1).forEach(_ -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				edges[u].add(v);
				edges[v].add(u);
			});
			used = new boolean[n];
			Arrays.fill(used, false);
			answer = 0;
			dfs(0);
			System.out.println(answer);
		}
	}

	/**
	 * aとbの最大公約数を返す
	 *
	 * @param a
	 * @param b
	 * @return aとbの最大公約数
	 */
	private static int gcd(int a, int b) {
		return (0 == b) ? a : gcd(b, a % b);
	}

	/**
	 * 深さ優先探索を行い、頂点 {@code now} を根とする部分木の集計結果を返します。
	 * <p>
	 * 各頂点について、頂点の値と部分木内の集計情報を保持し、 子頂点の集計結果を統合しながら、答え {@code answer} を更新します。
	 * <p>
	 * 返却するリストの各要素は、次の情報を保持します。
	 * <ul>
	 * <li>{@code a}: 部分木内で集計対象となる値</li>
	 * <li>{@code x}: その値に対応する集計数</li>
	 * <li>{@code y}: その値に対応する累積集計値</li>
	 * </ul>
	 *
	 * @param now 探索対象の頂点番号（0-indexed）
	 * @return 頂点 {@code now} を根とする部分木の集計結果を格納したリスト
	 */
	private static List<Data> dfs(int now) {
		used[now] = true;
		List<Data> list1 = new ArrayList<>(), list2 = new ArrayList<>();
		int[] index = new int[D];
		list1.add(new Data(a[now], 1L, 1L));
		for (int next : edges[now]) {
			if (!used[next]) {
				list2 = dfs(next);
				int size1 = list1.size(), size2 = list2.size(), defaultSize = size1;
				for (int j = 0; j < size2; j++) {
					index[j] = -1;
					for (int i = 0; i < size1; i++) {
						if (i < defaultSize) {
							int g = gcd(list1.get(i).a, list2.get(j).a);
							if (0 == i) {
								list2.get(j).a = g;
							}
							long x = list1.get(i).y * list2.get(j).x % MOD, y = list2.get(j).y * list1.get(i).x % MOD;
							answer = (answer + (x + y) * g % MOD) % MOD;
						}
						if (list1.get(i).a == list2.get(j).a) {
							index[j] = i;
						}
					}
					if (-1 == index[j]) {
						index[j] = size1;
						list1.add(new Data(list2.get(j).a, 0L, 0L));
						size1++;
					}
				}
				for (int j = 0; j < size2; j++) {
					list1.get(index[j]).x = (list1.get(index[j]).x + list2.get(j).x) % MOD;
					list1.get(index[j]).y = (list1.get(index[j]).y + list2.get(j).x + list2.get(j).y) % MOD;
				}
			}
		}
		return list1;
	}

	/**
	 * a,x,yを格納するクラス
	 */
	private static class Data {
		int a;
		long x, y;

		Data(int a, long x, long y) {
			this.a = a;
			this.x = x;
			this.y = y;
		}
	}
}
