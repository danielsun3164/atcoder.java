package abc.abc101_150.abc130;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc130/submissions/15075589 にも参考
 */
public class ProblemF {

	/** x軸正方向へ移動する文字 */
	private static final char R = 'R';
	/** x軸負方向へ移動する文字 */
	private static final char L = 'L';
	/** y軸正方向へ移動する文字 */
	private static final char U = 'U';
	/** y軸負方向へ移動する文字 */
	private static final char D = 'D';
	/** 計算するための最大値 */
	private static final double INF = 10E12;
	/** X座標かY座標の変化種類 */
	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data dx = new Data(), dy = new Data();
			IntStream.range(0, n).forEach(i -> {
				double x = scanner.nextInt(), y = scanner.nextInt();
				char d = scanner.next().charAt(0);
				switch (d) {
				case R -> {
					dx.add(x, 1);
					dy.add(y, 0);
				}
				case L -> {
					dx.add(x, -1);
					dy.add(y, 0);
				}
				case U -> {
					dx.add(x, 0);
					dy.add(y, 1);
				}
				case D -> {
					dx.add(x, 0);
					dy.add(y, -1);
				}
				}
			});
			Set<Double> set = new HashSet<>();
			set.add(0.0d);
			set.addAll(dx.events());
			set.addAll(dy.events());
			System.out.println(set.stream().mapToDouble(t -> dx.get(t) * dy.get(t)).min().getAsDouble());
		}
	}

	/**
	 * 座標のmax，minを計算するクラス
	 */
	private static class Data {
		/** 最小値を保存する配列 */
		double[] l = new double[N];
		/** 最大値を保存する配列 */
		double[] r = new double[N];

		Data() {
			Arrays.fill(l, INF);
			Arrays.fill(r, -INF);
		}

		/**
		 * 座標の値を追加
		 *
		 * @param x 値
		 * @param v 移動方向
		 */
		void add(double x, int v) {
			v++;
			l[v] = Math.min(l[v], x);
			r[v] = Math.max(r[v], x);
		}

		/**
		 * 時刻tの最大値と最小値の差分を計算する
		 *
		 * @param t
		 * @return 時刻tの最大値と最小値の差分
		 */
		double get(double t) {
			return IntStream.range(0, N).mapToDouble(i -> r[i] + t * i).max().getAsDouble()
					- IntStream.range(0, N).mapToDouble(i -> l[i] + t * i).min().getAsDouble();
		}

		/**
		 * 座標のmaxかminの変化時刻の一覧を計算する
		 *
		 * @return 座標のmaxかminの変化時刻の一覧
		 */
		Set<Double> events() {
			Set<Double> set = new HashSet<>();
			IntStream.range(0, N - 1).forEach(i -> IntStream.range(i + 1, N).forEach(j -> {
				double t = (l[i] - l[j]) / (j - i);
				if (t > 0.0d) {
					set.add(t);
				}
				t = (r[i] - r[j]) / (j - i);
				if (t > 0.0d) {
					set.add(t);
				}
			}));
			return set;
		}
	}
}
