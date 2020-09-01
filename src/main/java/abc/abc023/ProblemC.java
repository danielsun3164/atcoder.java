package abc.abc023;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通り実装したソースコード
 */
public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int k = scanner.nextInt();
			// 毎行の飴の数
			int[] rowCounts = new int[r];
			Arrays.fill(rowCounts, 0);
			// 毎列の飴の数
			int[] columnCounts = new int[c];
			Arrays.fill(columnCounts, 0);
			int n = scanner.nextInt();
			// 飴のあるコマの座標を保存する配列
			int[][] komas = new int[n][2];
			IntStream.range(0, n).forEach(i -> {
				int ri = scanner.nextInt() - 1;
				int ci = scanner.nextInt() - 1;
				rowCounts[ri]++;
				columnCounts[ci]++;
				komas[i][0] = ri;
				komas[i][1] = ci;
			});
			// 毎行の飴の数ごとの行数
			int[] rowNumbers = new int[c + 1];
			Arrays.fill(rowNumbers, 0);
			Arrays.stream(rowCounts).forEach(count -> rowNumbers[count]++);
			// 毎列の飴の数ごとの列数
			int[] columnNumbers = new int[r + 1];
			Arrays.fill(columnNumbers, 0);
			Arrays.stream(columnCounts).forEach(count -> columnNumbers[count]++);
			long answer = 0;
			for (int i = 0; i <= Math.min(k, c); i++) {
				if (k - i <= r) {
					answer += rowNumbers[i] * columnNumbers[k - i];
				}
			}
			for (int[] koma : komas) {
				int result = rowCounts[koma[0]] + columnCounts[koma[1]];
				if (k == result) {
					// 飴があるコマで行の飴数＋列の飴数=Kの場合は対象外
					answer--;
				} else if (k + 1 == result) {
					// 飴があるコマで行の飴数＋列の飴数=K+1の場合は対象
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
