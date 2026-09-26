package abc.abc201_250.abc242;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc242/submissions/29897678 にも参考
 */
public class ProblemG {

	/** Mo’s algorithmのブロックサイズ */
	private static final int BSIZE = 316;
	/**  */
	private static int[] a, count;
	private static int result, l, r;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			a = IntStream.range(0, n).map(_ -> scanner.nextInt() - 1).toArray();
			int q = scanner.nextInt();
			Query[] qv = IntStream.range(0, q).mapToObj(i -> new Query(i, scanner.nextInt() - 1, scanner.nextInt() - 1))
					.toArray(Query[]::new);
			Arrays.sort(qv, (x, y) -> {
				int xl = x.l / BSIZE, yl = y.l / BSIZE, xr = x.r, yr = y.r;
				if (xl != yl) {
					return Integer.compare(xl, yl);
				}
				if (xr == yr) {
					return Integer.compare(x.id, y.id);
				}
				return (0 == (xl & 1)) ? Integer.compare(xr, yr) : Integer.compare(yr, xr);
			});
			count = new int[n + 1];
			Arrays.fill(count, 0);
			int[] answer = new int[q];
			result = l = r = 0;
			add(0);
			IntStream.range(0, q).forEach(i -> answer[qv[i].id] = query(qv[i].l, qv[i].r));
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 要素を現在の区間に追加する。
	 *
	 * @param id 追加する要素のインデックス
	 */
	private static void add(int id) {
		count[a[id]]++;
		if ((count[a[id]] & 1) == 0) {
			result++;
		}
	}

	/**
	 * 要素を現在の区間から削除する。
	 *
	 * @param id 削除する要素のインデックス
	 */
	private static void remove(int id) {
		if ((count[a[id]] & 1) == 0) {
			result--;
		}
		count[a[id]]--;
	}

	/**
	 * 指定された区間に現在の区間を移動し、クエリの答えを求める。
	 *
	 * @param tl 目的区間の左端
	 * @param tr 目的区間の右端
	 * @return 指定区間における結果
	 */
	static int query(int tl, int tr) {
		if (!(r < tl)) {
			while (l < tl) {
				remove(l);
				l++;
			}
			while (tl < l) {
				l--;
				add(l);
			}
		}
		while (r < tr) {
			r++;
			add(r);
		}
		while (tr < r) {
			remove(r);
			r--;
		}
		while (l < tl) {
			remove(l);
			l++;
		}
		while (tl < l) {
			l--;
			add(l);
		}
		return result;
	}

	/**
	 * id,l,rを格納するクラス
	 */
	private static class Query {
		int id, l, r;

		Query(int id, int l, int r) {
			super();
			this.id = id;
			this.l = l;
			this.r = r;
		}
	}
}
