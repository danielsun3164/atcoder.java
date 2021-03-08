package abc.abc101_150.abc141;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * Z Algorithmの実装<br/>
 * https://atcoder.jp/contests/abc141/submissions/12859301 にも参考
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			System.out.println(IntStream.range(0, n - 1).map(i -> zAlgorithm(s, i)).max().getAsInt());
		}
	}

	/**
	 * Z Algorithmでsとs[start]の一致性を計算する
	 *
	 * @param s     文字列
	 * @param start 開始位置
	 * @return sのi文字目から i + start − 1 文字目までの部分文字列が start と一致する最大長さ
	 */
	private static int zAlgorithm(char[] s, int start) {
		int t = s.length - start;
		int[] r = new int[t];
		r[0] = t;
		int i = 1, j = 0;
		while (i < t) {
			while ((i + j < t) && (s[start + j] == s[start + i + j])) {
				j++;
			}
			r[i] = j;
			if (0 == j) {
				i++;
				continue;
			}
			int k = 1;
			while ((k < j) && (k + r[k] < j)) {
				r[i + k] = r[k];
				k++;
			}
			i += k;
			j -= k;
		}
		return IntStream.range(1, t).map(k -> Math.min(r[k], k)).max().getAsInt();
	}
}
