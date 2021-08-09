package abc.abc151_200.abc189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * TLE回避のため、System.out.printlnの代わりにStringBuilderを使用<br/>
 * それでもTLEのとき、再度同じソースコードを提出する
 */
public class ProblemE {

	/** 操作1を表す行列 */
	private static final long[][] OP1 = new long[][] { { 0, -1L, 0 }, { 1L, 0, 0 }, { 0, 0, 1L } };
	/** 操作2を表す行列 */
	private static final long[][] OP2 = new long[][] { { 0, 1L, 0 }, { -1L, 0, 0 }, { 0, 0, 1L } };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] x = new long[n], y = new long[n];
			IntStream.range(0, n).forEach(i -> {
				x[i] = scanner.nextLong();
				y[i] = scanner.nextLong();
			});
			int m = scanner.nextInt();
			int[] op = new int[m], p = new int[m];
			IntStream.range(0, m).forEach(i -> {
				op[i] = scanner.nextInt();
				if (op[i] >= 3) {
					p[i] = scanner.nextInt();
				}
			});
			int q = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Question>[] questions = new List[m + 1];
			IntStream.rangeClosed(0, m).forEach(i -> questions[i] = new ArrayList<>());
			IntStream.range(0, q)
					.forEach(i -> questions[scanner.nextInt()].add(new Question(scanner.nextInt() - 1, i)));
			/** 現在の操作前を表す行列 */
			long[][] now = new long[][] { { 1L, 0, 0 }, { 0, 1L, 0 }, { 0, 0, 1L } };
			/** 回答を保存する配列 */
			long[][] answer = new long[q][];
			for (int i = 0; i <= m; i++) {
				for (Question question : questions[i]) {
					answer[question.index] = mul(new long[][] { { x[question.b], y[question.b], 1L } }, now)[0];
				}
				if (i < m) {
					if (1 == op[i]) {
						now = mul(now, OP1);
					} else if (2 == op[i]) {
						now = mul(now, OP2);
					} else if (3 == op[i]) {
						now = mul(now, new long[][] { { -1L, 0, 0 }, { 0, 1L, 0 }, { 2L * p[i], 0, 1L } });
					} else {
						now = mul(now, new long[][] { { 1L, 0, 0 }, { 0, -1L, 0 }, { 0, 2L * p[i], 1L } });
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			IntStream.range(0, q).forEach(
					i -> sb.append(answer[i][0]).append(" ").append(answer[i][1]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 行列aと行列bの掛け算を計算する
	 *
	 * @param a
	 * @param b
	 * @return 行列aと行列bの掛け算の計算結果
	 */
	private static long[][] mul(long[][] a, long[][] b) {
		long[][] result = new long[a.length][b[0].length];
		IntStream.range(0, result.length).forEach(i -> Arrays.fill(result[i], 0L));
		IntStream.range(0, a.length).forEach(i -> IntStream.range(0, b[0].length)
				.forEach(j -> IntStream.range(0, a[i].length).forEach(k -> result[i][j] += a[i][k] * b[k][j])));
		return result;
	}

	/**
	 * bとindexを表すクラス
	 */
	private static class Question {
		int b, index;

		Question(int b, int index) {
			super();
			this.b = b;
			this.index = index;
		}
	}
}
