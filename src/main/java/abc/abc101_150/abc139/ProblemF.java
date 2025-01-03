package abc.abc101_150.abc139;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc139/submissions/17852121 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Vector[] vectors = new Vector[n];
			IntStream.range(0, n).forEach(i -> vectors[i] = new Vector(scanner.nextLong(), scanner.nextLong()));
			Arrays.sort(vectors);
			System.out.println(Math.sqrt(IntStream.range(0, n).mapToLong(i -> {
				Vector now = new Vector(0L, 0L);
				return IntStream.range(0, n).mapToLong(j -> {
					now.add(vectors[(i + j) % n]);
					return now.magnitude2();
				}).max().getAsLong();
			}).max().getAsLong()));
		}
	}

	/**
	 * ベクトルを表すクラス
	 */
	private static class Vector implements Comparable<Vector> {
		long x, y;

		Vector(long x, long y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * 現在のベクトルにvを加算する
		 *
		 * @param v
		 */
		void add(Vector v) {
			x += v.x;
			y += v.y;
		}

		/**
		 * 現在のベクトルの大きさの2乗を返す
		 *
		 * @return 現在のベクトルの大きさの2乗
		 */
		long magnitude2() {
			return x * x + y * y;
		}

		/**
		 * 第何象限にいるかを計算する
		 *
		 * @return 第何象限にいるか
		 */
		private int quadrant() {
			// 0は0象限
			if ((0 == sign(x)) && (0 == sign(y))) {
				return 0;
			}
			if (y > 0) {
				return (x > 0) ? 1 : 2;
			} else {
				return (x < 0) ? 3 : 4;
			}
		}

		/**
		 * aの符号を返す
		 *
		 * @param a
		 * @return aの符号
		 */
		int sign(long a) {
			return (a < 0L) ? -1 : ((0L == a) ? 0 : 1);
		}

		/**
		 * 現在のベクトルとvの内積を計算する
		 *
		 * @param v
		 * @return 現在のベクトルとvの内積
		 */
		@SuppressWarnings("unused")
		long dot(Vector v) {
			return x * v.x + y * v.y;
		}

		/**
		 * 現在のベクトルとvの外積を計算する
		 *
		 * @param v
		 * @return 現在のベクトルとvの外積
		 */
		long cross(Vector v) {
			return x * v.y - y * v.x;
		}

		/**
		 * 偏角ソート用の比較メソッド
		 *
		 * @param v
		 */
		@Override
		public int compareTo(Vector v) {
			int q = quadrant(), vq = v.quadrant();
			if (q != vq) {
				return Integer.compare(q, vq);
			}
			return sign(-cross(v));
		}
	}
}
