package abc.abc151_200.abc164;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc164/submissions/12391952 にも参考
 */
public class ProblemF {

	/** 入力数字の最大桁数 */
	private static final int N = 64;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] s = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] t = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long[] u = IntStream.range(0, n).mapToLong(i -> Long.parseUnsignedLong(scanner.next())).toArray();
			long[] v = IntStream.range(0, n).mapToLong(i -> Long.parseUnsignedLong(scanner.next())).toArray();
			long[][] temp = new long[n][n], answer = new long[n][n];
			IntStream.range(0, n).forEach(i -> Arrays.fill(answer[i], 0L));
			IntStream.range(0, N).forEach(i -> solve(n, s, t, u, v, temp, answer, i));
			if (!check(n, s, t, u, v, answer)) {
				System.out.println(-1);
				return;
			}
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer)
					.forEach(ansi -> sb.append(
							Arrays.stream(ansi).mapToObj(Long::toUnsignedString).collect(Collectors.joining(" ")))
							.append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 指定された位置の結果を計算する
	 *
	 * @param n      配列の長さ
	 * @param s
	 * @param t
	 * @param u
	 * @param v
	 * @param temp   各ビットの配列
	 * @param answer 結果の配列
	 * @param pos    現在処理している位置
	 */
	private static void solve(int n, int[] s, int[] t, long[] u, long[] v, long[][] temp, long[][] answer, int pos) {
		IntStream.range(0, n).forEach(i -> Arrays.fill(temp[i], 0L));
		IntStream.range(0, n).forEach(i -> {
			if ((0 == s[i]) && (1L == (1L & (u[i] >> pos)))) {
				Arrays.fill(temp[i], 1L);
			}
			if ((0 == t[i]) && (1L == (1L & (v[i] >> pos)))) {
				IntStream.range(0, n).forEach(j -> temp[j][i] = 1L);
			}
		});
		IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> {
			if (s[i] == t[j]) {
				if (0 == s[i]) {
					temp[i][j] = (1L & (u[i] >> pos)) | (1L & (v[j] >> pos));
				} else {
					temp[i][j] = (1L & (u[i] >> pos)) & (1L & (v[j] >> pos));
				}
			}
		}));
		long[] bits = new long[n];
		fill(n, s, t, u, v, temp, bits, pos);
		transpose(n, s, t, u, v, temp);
		fill(n, s, t, u, v, temp, bits, pos);
		transpose(n, s, t, u, v, temp);
		IntStream.range(0, n).forEach(i -> IntStream.range(0, n).forEach(j -> answer[i][j] |= (temp[i][j] << pos)));
	}

	/**
	 * 各配列にビットを入れる
	 *
	 * @param n    配列の長さ
	 * @param s
	 * @param t
	 * @param u
	 * @param v
	 * @param temp 各ビットの配列
	 * @param bits 残りのビット数の配列
	 * @param pos  現在処理している位置
	 */
	private static void fill(int n, int[] s, int[] t, long[] u, long[] v, long[][] temp, long[] bits, int pos) {
		Arrays.fill(bits, 0L);
		IntStream.range(0, n).filter(i -> 0 == t[i])
				.forEach(i -> bits[i] = n - 1 - IntStream.range(0, n).mapToLong(j -> temp[j][i]).sum());
		IntStream.range(0, n).filter(i -> (1 == s[i]) && (1L == ((u[i] >> pos) & 1L))).forEach(i -> {
			long valid = IntStream.range(0, n).mapToLong(j -> temp[i][j]).reduce(0L, (x, tij) -> x | tij);
			if (0L == valid) {
				for (int j = 0; j < n; j++) {
					if (bits[j] > 0L) {
						bits[j]--;
						temp[i][j] = 1L;
						break;
					}
				}
			}
		});
	}

	/**
	 * 配列を回転する
	 *
	 * @param n    配列の長さ
	 * @param s
	 * @param t
	 * @param u
	 * @param v
	 * @param temp 各ビットの配列
	 */
	private static void transpose(int n, int[] s, int[] t, long[] u, long[] v, long[][] temp) {
		IntStream.range(0, n).forEach(i -> {
			IntStream.range(0, i).forEach(j -> {
				// swap(temp[i][j], temp[j][i])
				long z = temp[i][j];
				temp[i][j] = temp[j][i];
				temp[j][i] = z;
			});
			// swap(u[i], v[i])
			long z = u[i];
			u[i] = v[i];
			v[i] = z;
			// swap(s[i], t[i])
			int y = s[i];
			s[i] = t[i];
			t[i] = y;
		});
	}

	/**
	 * 結果が条件に満たしているかどうかをチェックする
	 *
	 * @param n      配列の長さ
	 * @param s
	 * @param t
	 * @param u
	 * @param v
	 * @param answer 結果の配列
	 * @return 結果が条件に満たしているかどうか
	 */
	private static boolean check(int n, int[] s, int[] t, long[] u, long[] v, long[][] answer) {
		for (int i = 0; i < n; i++) {
			long andSum = -1L, orSum = 0L, andSum2 = -1L, orSum2 = 0L;
			for (int j = 0; j < n; j++) {
				andSum &= answer[i][j];
				orSum |= answer[i][j];
				andSum2 &= answer[j][i];
				orSum2 |= answer[j][i];
			}
			if (((0 == s[i]) && (andSum != u[i])) || ((1 == s[i]) && (orSum != u[i]))
					|| ((0 == t[i]) && (andSum2 != v[i])) || ((1 == t[i]) && (orSum2 != v[i]))) {
				return false;
			}
		}
		return true;
	}
}
