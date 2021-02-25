package abc.abc101_150.abc139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc139/submissions/7304833 に参考して作成したソースコード
 */
public class ProblemE別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[n][n - 1];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n - 1).forEach(j -> a[i][j] = scanner.nextInt() - 1));
			// over[i][j]はa[i][j]の試合が終了したかどうか
			boolean[][] over = new boolean[n][n - 1];
			// count[i]はチームiの実施試合数
			int[] count = new int[n];
			List<Integer> nextDay = new ArrayList<>();
			// 最初の試合実施可能かを判定
			IntStream.range(0, n).forEach(i -> {
				if (!over[i][0] && !over[a[i][0]][0] && (i == a[a[i][0]][0])) {
					over[i][0] = over[a[i][0]][0] = true;
					if (count[i] != n - 2) {
						nextDay.add(i);
					}
					if (count[a[i][0]] != n - 2) {
						nextDay.add(a[i][0]);
					}
				}
			});
			nextDay.stream().filter(ci -> count[ci] != n - 2).forEach(ci -> count[ci]++);
			int answer = 1;
			while (!nextDay.isEmpty()) {
				answer++;
				List<Integer> today = new ArrayList<>(nextDay);
				nextDay.clear();
				for (int x : today) {
					// xの次の対戦相手
					int y = a[x][count[x]];
					if (!over[x][count[x]] && !over[y][count[y]] && (x == a[y][count[y]])) {
						over[x][count[x]] = over[y][count[y]] = true;
						if (count[x] != n - 2) {
							nextDay.add(x);
						}
						if (count[y] != n - 2) {
							nextDay.add(y);
						}
					}
				}
				nextDay.stream().filter(ci -> count[ci] != n - 2).forEach(ci -> count[ci]++);
			}
			System.out.println((0 == Arrays.stream(count).filter(ci -> ci != n - 2).count()) ? answer : -1);
		}
	}
}
