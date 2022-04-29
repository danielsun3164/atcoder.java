package abc.abc151_200.abc161;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	/** 働くことが可能な日を表す文字 */
	private static final char OK = 'o';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt(), c = scanner.nextInt() + 1;
			char[] s = scanner.next().toCharArray();
			// 「x 回目に働く日は l[x] 日目以降 かつ r[x] 日目以以前の配列
			int[] l = new int[k], r = new int[k];
			int index = 0;
			for (int i = 0; i < k; i++) {
				while (OK != s[index]) {
					index++;
				}
				l[i] = index;
				index += c;
			}
			index = n - 1;
			for (int i = k - 1; i >= 0; i--) {
				while (OK != s[index]) {
					index--;
				}
				r[i] = index;
				index -= c;
			}
			// TLE対策のため、結果をStringBuilderにいれる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, k).filter(i -> l[i] == r[i])
					.forEach(i -> sb.append(l[i] + 1).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
