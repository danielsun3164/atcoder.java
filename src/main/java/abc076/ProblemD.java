package abc076;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] t = new int[n];
			IntStream.range(0, n).forEach(i -> t[i] = scanner.nextInt());
			// 時間制限区間の開始時間と終了時間
			int[] l = new int[n + 2], r = new int[n + 2];
			l[0] = r[0] = l[1] = 0;
			IntStream.range(0, n).forEach(i -> r[i + 1] = l[i + 2] = l[i + 1] + t[i]);
			r[n + 1] = l[n + 1];
			// 各区間の最大速度
			int[] v = new int[n + 2];
			v[0] = v[n + 1] = 0;
			IntStream.range(0, n).forEach(i -> v[i + 1] = scanner.nextInt());
			// 各時刻の最大速度(0.5秒刻み)
			double[] d = new double[r[n + 1] * 2 + 1];
			d[0] = 0.0d;
			System.out.println(IntStream.range(1, d.length).mapToDouble(i -> {
				d[i] = calcF(i, n, l, r, v);
				return (d[i - 1] + d[i]) / 4.0d;
			}).sum());
		}
	}

	/**
	 * 指定された時刻における走行可能の最大速度を取得する
	 * 
	 * @param index 時刻x2の値
	 * @param n     N
	 * @param l     時間帯のスタート時点
	 * @param r     時間帯のエンド時点
	 * @param v     時間帯の最大速度
	 * @return 指定された時刻における走行可能の最大速度
	 */
	private static double calcF(int index, int n, int[] l, int[] r, int[] v) {
		double time = index / 2.0d;
		return IntStream.range(0, n + 2).mapToDouble(i -> {
			if (time < l[i]) {
				return v[i] + (l[i] - time);
			} else if ((l[i] <= time) && (time <= r[i])) {
				return (double) v[i];
			} else {
				return v[i] + (time - r[i]);
			}
		}).min().getAsDouble();
	}
}
