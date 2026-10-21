package abc.abc201_250.abc246;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3705 の実装<br/>
 * https://atcoder.jp/contests/abc212/submissions/24641867 にも参考したが、高速化処理してあり
 */
public class ProblemEx2 {
	private static final long MOD = 998_244_353L;

	// 行優先で格納した3×3行列
	private static final long[][] MATRIX = { { 1, 1, 1, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 0, 0, 1 } };

	public static void main(String[] args) throws IOException {
		FastScanner fs = new FastScanner();
		@SuppressWarnings("unused")
		int n = fs.nextInt(), q = fs.nextInt();
		char[] s = fs.next().toCharArray();

		FastSegTree seg = new FastSegTree(s);
		StringBuilder sb = new StringBuilder(q * 11);
		while (q-- > 0) {
			int x = fs.nextInt() - 1;
			char c = fs.next().charAt(0);
			seg.set(x, c);
			sb.append(seg.getAnswer()).append(System.lineSeparator());
		}
		System.out.print(sb);
		System.out.flush();
	}

	static class FastSegTree {
		private final int size;

		// 各ノードにつき9要素。ノードkの先頭位置はk*9。
		private final long[] tree;

		FastSegTree(char[] s) {
			int n = s.length;
			int sz = 1;
			while (sz < n) {
				sz <<= 1;
			}
			size = sz;

			tree = new long[(size << 1) * 9];
			// 全ノードを単位行列で初期化
			for (int i = 1; i < (size << 1); i++) {
				int p = i * 9;
				tree[p] = 1;
				tree[p + 4] = 1;
				tree[p + 8] = 1;
			}

			// 葉に初期文字列を設定
			for (int i = 0; i < n; i++) {
				setLeaf(size + i, s[i]);
			}

			// 下からセグメント木を構築
			for (int i = size - 1; i >= 1; i--) {
				multiplyNode(i);
			}
		}

		void set(int p, char c) {
			p += size;
			setLeaf(p, c);

			while ((p >>= 1) > 0) {
				multiplyNode(p);
			}
		}

		private void setLeaf(int node, char c) {
			long[] m = switch (c) {
			case '0' -> MATRIX[0];
			case '1' -> MATRIX[1];
			default -> MATRIX[2];
			};
			System.arraycopy(m, 0, tree, node * 9, 9);
		}

		/**
		 * 子ノードの行列を左から右の順で乗算し、親ノードに格納します。
		 * <p>
		 * 結果の配列を新規作成せず、親ノードの領域を直接更新します。
		 * </p>
		 *
		 * @param k 更新対象のノード番号
		 */
		private void multiplyNode(int k) {
			int a = (k << 1) * 9;
			int b = a + 9;
			int r = k * 9;

			long a00 = tree[a], a01 = tree[a + 1], a02 = tree[a + 2], a10 = tree[a + 3], a11 = tree[a + 4],
					a12 = tree[a + 5], a20 = tree[a + 6], a21 = tree[a + 7], a22 = tree[a + 8];
			long b00 = tree[b], b01 = tree[b + 1], b02 = tree[b + 2], b10 = tree[b + 3], b11 = tree[b + 4],
					b12 = tree[b + 5], b20 = tree[b + 6], b21 = tree[b + 7], b22 = tree[b + 8];

			tree[r] = (a00 * b00 + a01 * b10 + a02 * b20) % MOD;
			tree[r + 1] = (a00 * b01 + a01 * b11 + a02 * b21) % MOD;
			tree[r + 2] = (a00 * b02 + a01 * b12 + a02 * b22) % MOD;

			tree[r + 3] = (a10 * b00 + a11 * b10 + a12 * b20) % MOD;
			tree[r + 4] = (a10 * b01 + a11 * b11 + a12 * b21) % MOD;
			tree[r + 5] = (a10 * b02 + a11 * b12 + a12 * b22) % MOD;

			tree[r + 6] = (a20 * b00 + a21 * b10 + a22 * b20) % MOD;
			tree[r + 7] = (a20 * b01 + a21 * b11 + a22 * b21) % MOD;
			tree[r + 8] = (a20 * b02 + a21 * b12 + a22 * b22) % MOD;
		}

		long getAnswer() {
			int root = 9;
			return (tree[root + 2] + tree[root + 5]) % MOD;
		}
	}

	static class FastScanner {
		private final BufferedInputStream in = new BufferedInputStream(System.in);

		private final byte[] buffer = new byte[1 << 16];
		private int ptr = 0;
		private int len = 0;

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

		String next() throws IOException {
			StringBuilder sb = new StringBuilder();
			int c;

			do {
				c = read();
			} while (c <= ' ' && c != -1);

			while (c > ' ') {
				sb.append((char) c);
				c = read();
			}

			return sb.toString();
		}

		int nextInt() throws IOException {
			int c;
			do {
				c = read();
			} while (c <= ' ' && c != -1);

			int sign = 1;
			if (c == '-') {
				sign = -1;
				c = read();
			}

			int result = 0;
			while (c > ' ') {
				result = result * 10 + c - '0';
				c = read();
			}
			return result * sign;
		}
	}
}
