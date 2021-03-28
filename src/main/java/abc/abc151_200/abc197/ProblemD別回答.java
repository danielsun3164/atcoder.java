package abc.abc151_200.abc197;

import java.util.Scanner;

/**
 * 半時計回りの座標計算はhttps://mathwords.net/heimenkaitenを参考
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int x0 = scanner.nextInt(), y0 = scanner.nextInt(), xn2 = scanner.nextInt(), yn2 = scanner.nextInt();
			// 中心点を求める
			double mx = (x0 + xn2) / 2.0d, my = (y0 + yn2) / 2.0d;
			// sinとcosを計算
			double sin = Math.sin(Math.PI * 2.0d / n), cos = Math.cos(Math.PI * 2.0d / n);
			// 中心点から見た点0を半時計回り回転
			double rx = cos * (x0 - mx) - sin * (y0 - my) + mx;
			double ry = sin * (x0 - mx) + cos * (y0 - my) + my;
			System.out.println(rx + " " + ry);
		}
	}
}
