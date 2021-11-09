package abc.abc001_050.abc008;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	/** 計算結果を保存するマップ */
	private static Map<List<Integer>, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int w = scanner.nextInt(), h = scanner.nextInt(), n = scanner.nextInt();
			// N個の座標値を入力する
			Point[] points = new Point[n];
			boolean[] canUsePoints = new boolean[n];
			IntStream.range(0, n).forEach(i -> {
				points[i] = new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
				canUsePoints[i] = true;
			});
			System.out.println(getResult(0, 0, w - 1, h - 1, points, canUsePoints));
		}
	}

	/**
	 * @param xs
	 * @param ys
	 * @param xe
	 * @param ye
	 * @param points       金塊回収装置の座標の配列
	 * @param canUsePoints 金塊回収装置の使用可能かの配列
	 * @return (xs,ys)->(xe,ye)の四角いエリアに対して回収できる最大金塊数
	 */
	private static int getResult(int xs, int ys, int xe, int ye, Point[] points, boolean[] canUsePoints) {
		List<Integer> key = Arrays.asList(xs, ys, xe, ye);
		Integer result = map.get(key);
		if (null != result) {
			return result;
		}
		int max = 0;
		if ((xe >= xs) && (ye >= ys)) {
			for (int i = 0; i < points.length; i++) {
				if (canUsePoints[i] && points[i].containsIn(xs, ys, xe, ye)) {
					canUsePoints[i] = false;
					int sum = xe - xs + ye - ys + 1;
					int xp = points[i].x;
					int yp = points[i].y;
					int total = sum + getResult(xs, ys, xp - 1, yp - 1, points, canUsePoints)
							+ getResult(xp + 1, ys, xe, yp - 1, points, canUsePoints)
							+ getResult(xs, yp + 1, xp - 1, ye, points, canUsePoints)
							+ getResult(xp + 1, yp + 1, xe, ye, points, canUsePoints);
					if (total > max) {
						max = total;
					}
					canUsePoints[i] = true;
				}
			}
		}
		map.put(key, max);
		return max;
	}

	/**
	 * x,yを表すクラス
	 */
	private static class Point {
		int x;
		int y;

		Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		/**
		 * @param xs
		 * @param ys
		 * @param xe
		 * @param ye
		 * @return 現在の座標は(xs,ys)->(xe,ye)の四角いエリアに含まれているかどうか
		 */
		boolean containsIn(int xs, int ys, int xe, int ye) {
			return ((x >= xs) && (x <= xe) && (y >= ys) && (y <= ye));
		}
	}
}
