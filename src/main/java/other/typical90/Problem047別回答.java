package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * Z-Algorigthmの実装
 */
public class Problem047別回答 {

	/** RGBの長さ */
	private static final int N = 3;
	/** RGB */
	private static final char[] RGB = { 'R', 'G', 'B' };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			char[] t = scanner.next().toCharArray();
			// それぞれRGBを交換した文字列を作成
			char[][] tt = new char[N][n];
			IntStream.range(0, N).forEach(i -> {
				IntStream.range(0, n).forEach(j -> {
					if (t[j] == RGB[i]) {
						tt[i][j] = RGB[(i + 1) % N];
					} else if (t[j] == RGB[(i + 1) % N]) {
						tt[i][j] = RGB[i];
					} else {
						tt[i][j] = t[j];
					}
				});
			});
			System.out.println(IntStream.range(0, N).map(i -> {
				char[] st = new char[n << 1], ts = new char[n << 1];
				System.arraycopy(s, 0, st, 0, n);
				System.arraycopy(tt[i], 0, st, n, n);
				System.arraycopy(tt[i], 0, ts, 0, n);
				System.arraycopy(s, 0, ts, n, n);
				int[] zst = zAlgorithm(st), zts = zAlgorithm(ts);
				return (int) IntStream.rangeClosed(1 - n, n - 1)
						.filter(k -> ((k < 0) && (n + k == zts[n - k])) || ((k >= 0) && (n - k == zst[n + k]))).count();
			}).sum());
		}
	}

	/**
	 * @param s 配列
	 * @return 長さnの配列。 i番目の要素は s[0..n)とs[i..n)のLCP(Longest Common Prefix)の長さ。
	 */
	private static int[] zAlgorithm(char[] s) {
		int n = s.length;
		if (0 == n) {
			return new int[] {};
		}
		int[] z = new int[n];
		z[0] = 0;
		for (int i = 1, j = 0; i < n; i++) {
			z[i] = (j + z[j] <= i) ? 0 : Math.min(j + z[j] - i, z[i - j]);
			while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
				z[i]++;
			}
			if (j + z[j] < i + z[i]) {
				j = i;
			}
		}
		z[0] = n;
		return z;
	}
}
