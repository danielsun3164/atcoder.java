package abc.abc201_250.abc232;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 順列のループは https://maku77.github.io/java/numstr/permutation.html を参考
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			List<Data> ab = IntStream.range(0, m).mapToObj(i -> new Data(scanner.nextInt() - 1, scanner.nextInt() - 1))
					.sorted((x, y) -> (x.a == y.a) ? Integer.compare(x.b, y.b) : Integer.compare(x.a, y.a)).toList();
			int[] c = new int[m], d = new int[m];
			IntStream.range(0, m).forEach(i -> {
				c[i] = scanner.nextInt() - 1;
				d[i] = scanner.nextInt() - 1;
			});
			System.out.println(permutation(m, ab, c, d, IntStream.range(0, n).toArray()) ? "Yes" : "No");
		}
	}

	/**
	 * cとdを順列で並び替えたあと、aとbと同じかどうかを判定する
	 *
	 * @param m    紐の数
	 * @param ab   aとbを表す一覧
	 * @param c
	 * @param d
	 * @param seed 0~n-1の配列
	 * @return cとdを順列で並び替えたあと、aとbと同じかどうか
	 */
	private static boolean permutation(int m, List<Data> ab, int[] c, int[] d, int[] seed) {
		int[] perm = new int[seed.length];
		boolean[] used = new boolean[seed.length];
		return buildPerm(m, ab, c, d, seed, perm, used, 0);
	}

	/**
	 * cとdを順列で並び替えたあと、aとbと同じかどうか
	 *
	 * @param m     紐の数
	 * @param ab    aとbを表す一覧
	 * @param c
	 * @param d
	 * @param seed  0~n-1の配列
	 * @param perm  現在並び替えた結果
	 * @param used  個々のボールが使ったかどうかの配列
	 * @param index 現在処理中のボール
	 * @return cとdを順列で並び替えたあと、aとbと同じかどうか
	 */
	private static boolean buildPerm(int m, List<Data> ab, int[] c, int[] d, int[] seed, int[] perm, boolean[] used,
			int index) {
		if (seed.length == index) {
			return procPerm(m, ab, c, d, perm);
		}

		for (int i = 0; i < seed.length; ++i) {
			if (!used[i]) {
				perm[index] = seed[i];
				used[i] = true;
				if (buildPerm(m, ab, c, d, seed, perm, used, index + 1)) {
					return true;
				}
				used[i] = false;
			}
		}
		return false;
	}

	/**
	 * cとdを並び替えたあと、aとbと同じかどうかを判定する
	 *
	 * @param m    紐の数
	 * @param ab   aとbを表す一覧
	 * @param c
	 * @param d
	 * @param perm cとdの並び替える方法
	 * @return cとdを並び替えたあと、aとbと同じかどうか
	 */
	private static boolean procPerm(int m, List<Data> ab, int[] c, int[] d, int[] perm) {
		List<Data> cd = IntStream.range(0, m).mapToObj(i -> new Data(perm[c[i]], perm[d[i]]))
				.sorted((x, y) -> (x.a == y.a) ? Integer.compare(x.b, y.b) : Integer.compare(x.a, y.a)).toList();
		return ab.equals(cd);
	}

	/**
	 * a,bを格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = Math.min(a, b);
			this.b = Math.max(a, b);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Data other) {
				return (a == other.a) && (b == other.b);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(a, b);
		}
	}
}
