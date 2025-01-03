package abc.abc101_150.abc139;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc139/submissions/7309570 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[][] a = new int[n][n - 1];
			IntStream.range(0, n).forEach(i -> IntStream.range(0, n - 1).forEach(j -> a[i][j] = scanner.nextInt() - 1));
			System.out.println(getResult(n, a));
		}
	}

	/**
	 * 試合実施の最大日数を計算する
	 *
	 * @param n チーム数
	 * @param a 試合相手の順番の配列
	 * @return 試合実施の最大日数
	 */
	private static int getResult(int n, int[][] a) {
		Queue<Game> que = new ArrayDeque<>();
		// 初日の処理
		Set<Integer> used = new HashSet<>();
		IntStream.range(0, n).forEach(i -> {
			int j = a[i][0];
			if (!used.contains(i) && !used.contains(j)) {
				if (i == a[j][0]) {
					que.add(new Game(i, j, 1));
					used.add(i);
					used.add(j);
				}
			}
		});

		int[] indice = new int[n];
		int answer = 0;
		while (!que.isEmpty()) {
			Game game = que.poll();
			answer = Math.max(answer, game.day);
			indice[game.a]++;
			indice[game.b]++;
			if (indice[game.a] < n - 1) {
				int c = a[game.a][indice[game.a]];
				if (game.a == a[c][indice[c]]) {
					que.add(new Game(game.a, c, game.day + 1));
				}
			}
			if (indice[game.b] < n - 1) {
				int d = a[game.b][indice[game.b]];
				if (game.b == a[d][indice[d]]) {
					que.add(new Game(game.b, d, game.day + 1));
				}
			}
		}
		return (Arrays.stream(indice).filter(di -> di != n - 1).count() > 0) ? -1 : answer;
	}

	/**
	 * 試合を表すクラス
	 */
	private static class Game {
		int a, b, day;

		Game(int a, int b, int day) {
			this.a = a;
			this.b = b;
			this.day = day;
		}
	}
}
