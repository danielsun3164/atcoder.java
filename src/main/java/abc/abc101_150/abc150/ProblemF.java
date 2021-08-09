package abc.abc101_150.abc150;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc150/submissions/18815281 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] s = IntStream.range(0, 2 * n).map(i -> a[i % n] ^ a[(i + 1) % n]).toArray();
			int[] t = IntStream.range(0, n).map(i -> b[i % n] ^ b[(i + 1) % n]).toArray();
			int[] longestMatch = kmp(s, t);
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n).filter(i -> n == longestMatch[i + 2 * n])
					.forEach(i -> sb.append(i).append(" ").append(b[0] ^ a[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * sとtのKMPを計算する
	 *
	 * @param s
	 * @param t
	 * @return sとtのKMP
	 */
	private static int[] kmp(int[] s, int[] t) {
		int[] p = new int[t.length + 1 + s.length];
		System.arraycopy(t, 0, p, 0, t.length);
		p[t.length] = -1;
		System.arraycopy(s, 0, p, t.length + 1, s.length);
		int[] prefixLength = new int[p.length];
		Arrays.fill(prefixLength, 0);
		for (int j = 1; j < p.length; j++) {
			int i = prefixLength[j - 1];
			while ((i > 0) && (p[i] != p[j])) {
				i = prefixLength[i - 1];
			}
			if (p[i] == p[j]) {
				i++;
			}
			prefixLength[j] = i;
		}
		return prefixLength;
	}
}
