package abc.abc201_250.abc246;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3727 の実装<br/>
 * https://atcoder.jp/contests/abc246/submissions/30681804 にも参考
 */
public class ProblemF別回答 {

	/** mod対象数字 */
	private static final int MOD = 998_244_353;
	/** 英文字の文字数 */
	private static final int N = 26;
	/** bit計算の場合、26通りの条件件数 */
	private static final int LIMIT = 1 << N;

	public static void main(String[] args) throws Exception {
		FastScanner scanner = new FastScanner();
		int n = scanner.nextInt(), l = scanner.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			char[] t = scanner.next().toCharArray();
			s[i] = 0;
			for (char c : t) {
				s[i] |= 1 << (c - 'a');
			}
		}

		// 二項係数の前計算
		int[][] binom = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			binom[i][0] = binom[i][i] = 1;
			for (int j = 1; j < i; j++) {
				binom[i][j] = (binom[i - 1][j - 1] + binom[i - 1][j]) % MOD;
			}
		}

		// べき乗の前計算
		int[] powers = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			powers[i] = modPow(i, l);
		}

		// g[i] = Σ (-1)^j * C(i,j) * (i-j)^l
		int[] g = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			long sum = 0;
			for (int j = 0; j <= i; j++) {
				long v = (long) binom[i][j] * powers[i - j] % MOD;
				if ((j & 1) == 0) {
					sum += v;
					if (sum >= MOD) {
						sum -= MOD;
					}
				} else {
					sum -= v;
					if (sum < 0) {
						sum += MOD;
					}
				}
			}
			g[i] = (int) sum;
		}

		// 全ての部分集合を列挙
		long answer = 0;
		for (int a = 0; a < LIMIT; a++) {
			boolean found = false;
			for (int e : s) {
				if ((e & a) == a) {
					found = true;
					break;
				}
			}
			if (found) {
				answer += g[Integer.bitCount(a)];
				if (answer >= MOD) {
					answer -= MOD;
				}
			}
		}
		System.out.println(answer);
	}

	/**
	 * 指数法を用いて、整数の累乗を法 MOD で計算する。
	 *
	 * <p>
	 * 計算する値は {@code base^exp mod MOD} である。 二分累乗法を使用するため、計算量は O(log exp) となる。
	 * </p>
	 *
	 * @param base 底となる整数（0以上 MOD 未満を想定）
	 * @param exp  指数（0以上）
	 * @return {@code base^exp mod MOD} の計算結果（0以上 MOD 未満）
	 */
	private static int modPow(int base, int exp) {
		long result = 1, x = base;
		while (exp > 0) {
			if ((exp & 1) != 0) {
				result = result * x % MOD;
			}
			x = x * x % MOD;
			exp >>= 1;
		}
		return (int) result;
	}

	/**
	 * 標準入力から整数および文字列を高速に読み込むためのクラス。
	 *
	 * <p>
	 * {@link BufferedInputStream} とバッファを使用して、 1文字ずつ読み込む際の入出力オーバーヘッドを軽減する。
	 * </p>
	 *
	 * <p>
	 * * 空白文字（スペース、改行、タブなど）を区切りとして扱う。
	 * </p>
	 */
	static final class FastScanner {
		private final BufferedInputStream in = new BufferedInputStream(System.in, 1 << 16);

		private final byte[] buffer = new byte[1 << 16];
		private int ptr = 0, len = 0;

		/**
		 * 入力から1バイトを読み込む。
		 *
		 * <p>
		 * 内部バッファにデータが残っていない場合は、 標準入力から次のデータを読み込む。
		 * </p>
		 *
		 * @return 読み込んだバイト値（0～255）、または入力終端の場合は -1
		 * @throws IOException 入力の読み込み中に入出力エラーが発生した場合
		 */
		private int read() throws IOException {
			if (ptr >= len) {
				len = in.read(buffer);
				ptr = 0;
				if (len <= 0) {
					return -1;
				}
			}
			return buffer[ptr++];
		}

		/**
		 * 標準入力から次の整数を読み込む。
		 *
		 * <p>
		 * 先行する空白文字を読み飛ばし、空白文字または入力終端までの 数字を整数として解釈する。
		 * </p>
		 *
		 * @return 読み込んだ整数
		 * @throws IOException 入力の読み込み中に入出力エラーが発生した場合
		 */
		int nextInt() throws IOException {
			int c;
			do {
				c = read();
			} while (c <= ' ' && c != -1);

			int value = 0;
			while (c > ' ') {
				value = value * 10 + c - '0';
				c = read();
			}
			return value;
		}

		/**
		 * 標準入力から次の空白区切り文字列を読み込む。
		 *
		 * <p>
		 * 先行する空白文字を読み飛ばし、次の空白文字または 入力終端までの文字列を返す。
		 * </p>
		 *
		 * @return 読み込んだ文字列
		 * @throws IOException 入力の読み込み中に入出力エラーが発生した場合
		 */
		String next() throws IOException {
			int c;
			do {
				c = read();
			} while (c <= ' ' && c != -1);

			StringBuilder sb = new StringBuilder();
			while (c > ' ') {
				sb.append((char) c);
				c = read();
			}
			return sb.toString();
		}
	}
}
