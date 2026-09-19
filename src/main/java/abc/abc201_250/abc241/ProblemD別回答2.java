package abc.abc201_250.abc241;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3486 の実装<br/>
 * https://atcoder.jp/contests/abc241/submissions/30995250 にも参考
 */
public class ProblemD別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			long[] a = new long[q];
			Query[] queries = new Query[q];
			int aSize = 0;
			for (int i = 0; i < q; i++) {
				int t = scanner.nextInt();
				if (t == 1) {
					long x = scanner.nextLong();
					a[aSize++] = x;
					queries[i] = new Query(1, 0, 0);
				} else {
					long x = scanner.nextLong();
					// 入力された k を k - 1 に変換
					int k = scanner.nextInt() - 1;
					queries[i] = new Query(t, x, k);
				}
			}
			long[] values = Arrays.copyOf(a, aSize);
			WaveletMatrix wm = new WaveletMatrix(values);
			int r = 0;
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (Query query : queries) {
				int t = query.type, k = query.k;
				long x = query.x;
				if (t == 1) {
					r++;
					continue;
				}
				Count3wayResult c3 = wm.count3way(0, r, x);
				if (t == 2) {
					// x以下の個数がk以下なら、k番目以下の値は存在しない
					if (c3.le() <= k) {
						sb.append("-1").append(System.lineSeparator());
					} else {
						sb.append(wm.quantile(0, r, c3.le() - k - 1)).append(System.lineSeparator());
					}
				} else if (t == 3) {
					// x以上の個数がk以下なら、k番目以上の値は存在しない
					if (c3.ge() <= k) {
						sb.append("-1").append(System.lineSeparator());
					} else {
						sb.append(wm.quantile(0, r, c3.lt + k)).append(System.lineSeparator());
					}
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	static class Query {
		int type;
		long x;
		int k;

		Query(int type, long x, int k) {
			this.type = type;
			this.x = x;
			this.k = k;
		}
	}

	static class Count3wayResult {
		int lt, eq, gt;

		Count3wayResult(int lt, int eq, int gt) {
			this.lt = lt;
			this.eq = eq;
			this.gt = gt;
		}

		int le() {
			return lt + eq;
		}

		int ge() {
			return gt + eq;
		}

		int ne() {
			return lt + gt;
		}
	}

	static class WaveletMatrix {
		private final int len, bitlen;
		private final RsDict[] buf;
		private final int[] zeros;

		WaveletMatrix(long[] orig) {
			len = orig.length;
			bitlen = 64;
			long[] whole = orig.clone();
			buf = new RsDict[bitlen];
			zeros = new int[bitlen];

			for (int i = bitlen - 1; i >= 0; i--) {
				long[] zero = new long[len], one = new long[len];
				int zeroSize = 0, oneSize = 0;
				boolean[] vb = new boolean[len];
				for (int j = 0; j < whole.length; j++) {
					long value = whole[j];
					boolean bit = ((value >>> i) & 1L) != 0;
					vb[j] = bit;
					if (bit) {
						one[oneSize++] = value;
					} else {
						zero[zeroSize++] = value;
					}
				}
				zeros[i] = zeroSize;
				buf[i] = new RsDict(vb);
				whole = new long[zeroSize + oneSize];
				System.arraycopy(zero, 0, whole, 0, zeroSize);
				System.arraycopy(one, 0, whole, zeroSize, oneSize);
			}
		}

		/**
		 * [start, end) の中で value より小さい個数、 大きい個数を求める。
		 */
		private int[] count3wayInternal(int start, int end, long value) {
			if (start == end) {
				return new int[] { 0, 0 };
			}

			int lt = 0, gt = 0;
			for (int i = bitlen - 1; i >= 0; i--) {
				int tmp = end - start;
				if (!testBit(value, i)) {
					start = buf[i].rank(start, 0);
					end = buf[i].rank(end, 0);
					gt += tmp - (end - start);
				} else {
					start = zeros[i] + buf[i].rank(start, 1);
					end = zeros[i] + buf[i].rank(end, 1);
					lt += tmp - (end - start);
				}
			}
			return new int[] { lt, gt };
		}

		/**
		 * [start, end) に value が何個あるか、 < value, == value, > value の3種類を返す。
		 */
		Count3wayResult count3way(int start, int end, long value) {
			int[] result = count3wayInternal(start, end, value);
			int lt = result[0], gt = result[1], eq = (end - start) - (lt + gt);
			return new Count3wayResult(lt, eq, gt);
		}

		/**
		 * [start, end) を昇順に並べたときの index=n の値を返す。
		 */
		long quantile(int start, int end, int n) {
			if (end - start <= n) {
				throw new IllegalArgumentException("quantile index out of range");
			}

			long result = 0L;
			for (int i = bitlen - 1; i >= 0; i--) {
				int z = buf[i].count(start, end, 0);
				if (n < z) {
					start = buf[i].rank(start, 0);
					end = buf[i].rank(end, 0);
				} else {
					result = setBit(result, i);
					start = zeros[i] + buf[i].rank(start, 1);
					end = zeros[i] + buf[i].rank(end, 1);
					n -= z;
				}
			}
			return result;
		}

		private static boolean testBit(long value, int i) {
			return ((value >>> i) & 1L) != 0;
		}

		private static long setBit(long value, int i) {
			return value | (1L << i);
		}
	}

	static class RsDict {
		private static final int WORD_SIZE = 64;

		private final int len;
		// 64bitずつ圧縮したビット列
		private final long[] buf;
		// rank[i] = buf[0..i-1] に含まれる1の個数
		private final int[] rank;

		RsDict(boolean[] bits) {
			len = bits.length;
			int wordCount = (len + WORD_SIZE - 1) / WORD_SIZE;
			buf = new long[wordCount + 1];
			for (int i = 0; i < len; i++) {
				if (bits[i]) {
					buf[i / WORD_SIZE] |= 1L << (i % WORD_SIZE);
				}
			}
			rank = new int[buf.length];
			for (int i = 1; i < buf.length; i++) {
				rank[i] = rank[i - 1] + Long.bitCount(buf[i - 1]);
			}
		}

		/**
		 * [0, end) に x が何個あるか。
		 */
		int rank(int end, int x) {
			if (end <= 0) {
				return 0;
			}

			if (end > len) {
				end = len;
			}

			int il = end / WORD_SIZE, is = end % WORD_SIZE, rank1 = rank[il];
			if ((is != 0) && (il < buf.length)) {
				long mask = (is == 64) ? -1L : ((1L << is) - 1);
				rank1 += Long.bitCount(buf[il] & mask);
			}
			return (x == 0) ? end - rank1 : rank1;
		}

		/**
		 * [start,end) の中の x の個数。
		 */
		int count(int start, int end, int x) {
			return rank(end, x) - rank(start, x);
		}
	}
}
