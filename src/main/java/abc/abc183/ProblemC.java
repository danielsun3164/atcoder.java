package abc.abc183;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			int[][] t = new int[n][];
			IntStream.range(0, n).forEach(i -> t[i] = IntStream.range(0, n).map(j -> scanner.nextInt()).toArray());
			System.out.println(getResult(0, n, 0L, k, t, new boolean[n]));
		}
	}

	/**
	 * 現在到着している都市から一周して都市0に戻るまでかかった移動時間がちょうどkとなるケース数を計算する
	 * 
	 * @param current 現在到着している都市
	 * @param n       都市の総数
	 * @param time    これまでかかった移動時間
	 * @param k       目標移動時間
	 * @param t       都市間移動時間の配列
	 * @param visited 各都市が到着したかどうかの配列
	 * @return 一周して都市0に戻るまでかかった移動時間がちょうどkとなるケース数
	 */
	private static int getResult(int current, final int n, long time, final long k, final int[][] t,
			boolean[] visited) {
		if (1 == IntStream.range(0, n).filter(i -> !visited[i]).count()) {
			return (k == time + t[current][0]) ? 1 : 0;
		}
		int result = 0;
		visited[current] = true;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				result += getResult(i, n, time + t[current][i], k, t, visited);
			}
		}
		visited[current] = false;
		return result;
	}
}
