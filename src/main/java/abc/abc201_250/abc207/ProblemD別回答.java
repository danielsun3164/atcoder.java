package abc.abc201_250.abc207;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 極座標を実装したソースコード
 */
public class ProblemD別回答 {

	/** 誤差 */
	private static final double EPS = 1E-6d;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] s = input(scanner, n), t = input(scanner, n);
			double maxSR = s[0].r, maxTR = t[0].r;
			if (Math.abs(maxSR - maxTR) < EPS) {
				int index = 0;
				while ((index < n) && (t[index].r == maxTR)) {
					if (check(s, t, s[0].theta - t[index].theta)) {
						System.out.println("Yes");
						return;
					}
					index++;
				}
			}
			System.out.println("No");
		}
	}

	/**
	 * 長さnの座標を入力して、極座標の配列へ変換する
	 *
	 * @param scanner
	 * @param n       配列の長さ
	 */
	private static Data[] input(Scanner scanner, int n) {
		int[] x = new int[n], y = new int[n];
		IntStream.range(0, n).forEach(i -> {
			x[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
		});
		int xSum = Arrays.stream(x).sum(), ySum = Arrays.stream(y).sum();
		IntStream.range(0, n).forEach(i -> {
			x[i] = (x[i] * n) - xSum;
			y[i] = (y[i] * n) - ySum;
		});
		return IntStream.range(0, n).mapToObj(i -> new Data(Math.hypot(x[i], y[i]), Math.atan2(y[i], x[i])))
				.sorted((a, b) -> (a.r == b.r) ? Double.compare(b.theta, a.theta) : Double.compare(b.r, a.r))
				.toArray(Data[]::new);
	}

	/**
	 * tの座標の角度の差分を適用した後，sと一致するかどうかをチェック
	 *
	 * @param s
	 * @param t
	 * @param diff 角度の差分
	 * @return tの座標の半径の倍率と角度の差分を適用した後，sと一致するかどうか
	 */
	private static boolean check(Data[] s, Data[] t, double diff) {
		Data[] newT = Arrays.stream(t).map(data -> new Data(data.r, (data.r < EPS) ? 0.0d : adjust(data.theta + diff)))
				.sorted((a, b) -> (a.r == b.r) ? Double.compare(b.theta, a.theta) : Double.compare(b.r, a.r))
				.toArray(Data[]::new);
		for (int i = 0; i < s.length; i++) {
			if ((Math.abs(s[i].r - newT[i].r) >= EPS) || (Math.abs(s[i].theta - newT[i].theta) >= EPS)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 入力角度を (-π,π] の値に調整する
	 *
	 * @param d 入力角度
	 * @return 入力角度を (-π,π] の値に調整した値
	 */
	private static double adjust(double d) {
		if (d > Math.PI) {
			return d - 2 * Math.PI;
		} else if (d <= -Math.PI) {
			return d + 2 * Math.PI;
		}
		return d;
	}

	/**
	 * 極座標のr,thetaを格納するクラス
	 */
	private static class Data {
		double r, theta;

		Data(double r, double theta) {
			super();
			this.r = r;
			this.theta = theta;
		}
	}
}
