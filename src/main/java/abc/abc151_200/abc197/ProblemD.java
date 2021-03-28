package abc.abc151_200.abc197;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int x0 = scanner.nextInt(), y0 = scanner.nextInt(), xn2 = scanner.nextInt(), yn2 = scanner.nextInt();
			// 中心点を求める
			double mx = (x0 + xn2) / 2.0d, my = (y0 + yn2) / 2.0d;
			// p0の方位を計算する
			double theta = Math.atan2(y0 - my, x0 - mx);
			// 半時計回り回転
			theta += Math.PI * 2.0d / n;
			// 中心点からの距離
			double d = Math.hypot(x0 - mx, y0 - my);
			// p1の座標を計算する
			double rx = d * Math.cos(theta) + mx;
			double ry = d * Math.sin(theta) + my;
			System.out.println(rx + " " + ry);
		}
	}
}
