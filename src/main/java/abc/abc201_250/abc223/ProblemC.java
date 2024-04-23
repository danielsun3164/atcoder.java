package abc.abc201_250.abc223;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			double time = IntStream.range(0, n).mapToDouble(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
				return a[i] / (double) b[i];
			}).sum();
			System.out.println(calcDistance(a, b, time / 2.0d));
		}
	}

	/**
	 * 燃焼時間から燃焼距離を計算する
	 *
	 * @param a    長さの配列
	 * @param b    燃焼速度の配列
	 * @param time 燃焼時間
	 * @return 燃焼距離
	 */
	private static double calcDistance(int[] a, int[] b, double time) {
		double result = 0.0d;
		for (int i = 0; i < a.length; i++) {
			double timeNow = a[i] / (double) b[i];
			if (time > timeNow) {
				time -= timeNow;
				result += a[i];
			} else {
				result += time * b[i];
				break;
			}
		}
		return result;
	}
}
