package abc.abc101_150.abc138;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc138/submissions/6976109 にも参考
 */
public class ProblemF {

	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long l = scanner.nextLong(), r = scanner.nextLong();
			long[][][][] memo = new long[60][2][2][2];
			IntStream.range(0, memo.length).forEach(i -> IntStream.range(0, memo[i].length)
					.forEach(j -> IntStream.range(0, memo[i][j].length).forEach(k -> Arrays.fill(memo[i][j][k], -1L))));
			System.out.println(dfs(l, r, memo, 59, 0, 0, 0));
		}
	}

	/**
	 * @param l        最小値
	 * @param r        最大値
	 * @param memo     計算結果
	 * @param position 現在計算中の桁
	 * @param x
	 * @param y
	 * @param z
	 * @return 計算結果
	 */
	private static long dfs(final long l, final long r, final long[][][][] memo, int position, int x, int y, int z) {
		if (-1 == position) {
			return 1L;
		}
		if (-1 != memo[position][x][y][z]) {
			return memo[position][x][y][z];
		}
		long answer = 0L;
		// x=0, y=0
		if ((1 == x) || ((l & (1L << position)) == 0)) {
			answer += dfs(l, r, memo, position - 1, x, ((r & (1L << position)) > 0) ? 1 : y, z);
		}
		// x=0, y=1
		if (((1 == x) || ((l & (1L << position)) == 0)) && ((1 == y) || ((r & (1L << position)) > 0)) && (1 == z)) {
			answer += dfs(l, r, memo, position - 1, x, y, z);
		}
		// x=1, y=1
		if ((1 == y) || ((r & (1L << position)) > 0)) {
			answer += dfs(l, r, memo, position - 1, ((l & (1L << position)) == 0) ? 1 : x, y, 1);
		}
		answer %= MOD;
		memo[position][x][y][z] = answer;
		return answer;
	}
}
