package other.joi2006ho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 周の長さの計算方法は解説通りに実装
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), r = scanner.nextInt();
			// y1でソートする
			Region[] regions = IntStream.range(0, n)
					.mapToObj(
							i -> new Region(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()))
					.sorted((a, b) -> Integer.compare(a.y1, b.y1)).toArray(Region[]::new);
			int xMax = 0, xMin = Integer.MAX_VALUE, yMax = 0, yMin = Integer.MAX_VALUE;
			for (Region region : regions) {
				xMax = Math.max(xMax, region.x2);
				xMin = Math.min(xMin, region.x1);
				yMax = Math.max(yMax, region.y2);
				yMin = Math.min(yMin, region.y1);
			}
			int[][] dp = new int[2][xMax - xMin + 2];
			IntStream.range(0, 2).forEach(i -> Arrays.fill(dp[i], 0));
			// 現在処理している長方形のindex
			int count = 0;
			// 現在の処理対象の長方形一覧
			List<Region> list = new ArrayList<>();
			// 面積と周の長さ
			long area = 0L, perimeter = 0L;
			// 現在処理している行
			for (int currentLine = yMin; currentLine <= yMax; currentLine++) {
				// 現在処理の行のデータをクリア
				Arrays.fill(dp[currentLine & 1], 0);
				// 現在の行から処理対象となる長方形を追加
				while ((count < n) && (regions[count].y1 == currentLine)) {
					list.add(regions[count++]);
				}
				for (int j = 0; j < list.size(); j++) {
					Region region = list.get(j);
					// すでに通過した長方形を一覧から削除
					if (region.y2 == currentLine) {
						list.remove(j);
						j--;
					} else {
						dp[currentLine & 1][region.x1 - xMin]++;
						dp[currentLine & 1][region.x2 - xMin]--;
					}
				}
				// imos法で計算
				for (int j = 1; j < dp[currentLine & 1].length; j++) {
					dp[currentLine & 1][j] += dp[currentLine & 1][j - 1];
				}
				for (int j = 0; j < dp[currentLine & 1].length; j++) {
					if (dp[currentLine & 1][j] > 0) {
						// 面積を追加
						area++;
						// 左側と比較する
						if ((0 == j) || (0 == dp[currentLine & 1][j - 1])) {
							// 周の長さを追加
							perimeter++;
						}
						// 右側と比較する
						if ((dp[currentLine & 1].length - 1 == j) || (0 == dp[currentLine & 1][j + 1])) {
							// 周の長さを追加
							perimeter++;
						}
						// 下の行と比較する
						if (0 == dp[(currentLine - 1) & 1][j]) {
							// 周の長さを追加
							perimeter++;
						}
					} else {
						// 自分が上の空きとして、下の行と比較する
						if (dp[(currentLine - 1) & 1][j] > 0) {
							// 周の長さを追加
							perimeter++;
						}
					}
				}
			}
			System.out.println(area);
			if (2 == r) {
				System.out.println(perimeter);
			}
		}
	}

	/**
	 * 長方形の四つの頂点を表すクラス
	 */
	private static class Region {
		int x1, y1, x2, y2;

		Region(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
