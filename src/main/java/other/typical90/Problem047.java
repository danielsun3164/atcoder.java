package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem047 {

	/** RGBの長さ */
	private static final int N = 3;
	/** RGB */
	private static final char[] RGB = { 'R', 'G', 'B' };
	/** ハッシュ計算するためのB */
	private static final long B = 127L;
	/** ハッシュ計算するためのP */
	private static final long P = 998_244_353L;

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
			// powB[i]=B^i mod P
			long[] powB = new long[n + 1];
			powB[0] = 1L;
			IntStream.rangeClosed(1, n).forEach(i -> powB[i] = powB[i - 1] * B % P);
			// sのハッシュ値
			long[] hashS = new long[n + 1];
			hashS[0] = 0L;
			IntStream.range(0, n).forEach(i -> hashS[i + 1] = (hashS[i] * B + s[i]) % P);
			// 変換された各tのハッシュ値
			long[][] hashTt = new long[N][n + 1];
			IntStream.range(0, N).forEach(i -> {
				hashTt[i][0] = 0L;
				IntStream.range(0, n).forEach(j -> hashTt[i][j + 1] = (hashTt[i][j] * B + tt[i][j]) % P);
			});
			System.out.println(IntStream.rangeClosed(1 - n, n - 1).filter(k -> {
				if (k < 0) {
					// hashSk=hash(s_{-k+1}...s_n)
					long hashSk = (hashS[n] - powB[n + k] * hashS[-k] % P + P) % P;
					return IntStream.range(0, N).filter(i -> {
						// hashTtk=hash(t_1...t_{n+k})
						long hashTtk = hashTt[i][n + k];
						return hashTtk == hashSk;
					}).count() > 0;
				} else {
					// hashSk=hash(s_1...s_{n-k})
					long hashSk = hashS[n - k];
					return IntStream.range(0, N).filter(i -> {
						// hashTtk=hash(t_{k+1}...t_n)
						long hashTtk = (hashTt[i][n] - powB[n - k] * hashTt[i][k] % P + P) % P;
						return hashTtk == hashSk;
					}).count() > 0;
				}
			}).count());
		}
	}
}
