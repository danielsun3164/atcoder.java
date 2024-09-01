package abc.abc201_250.abc234;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc234/editorial/3246 のwavelet matrixでの実装<br/>
 * https://drken1215.hatenablog.com/entry/2023/10/15/003821 にも参考<br/>
 * Wavelet Matrixの実装はhttps://atcoder.jp/contests/abc231/submissions/27836317 を参考
 */
public class ProblemD別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] p = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			WaveletMatrix wm = new WaveletMatrix(p);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.rangeClosed(k, n)
					.forEach(i -> sb.append(wm.kthLargest(0, i, k - 1)).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * int型のaとbを格納するクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	private static class WaveletMatrix {
		private static final int MAXLOG = 20;
		int length;
		SuccinctIndexableDictionary[] matrix = new SuccinctIndexableDictionary[MAXLOG];
		int[] mid = new int[MAXLOG];

		WaveletMatrix(long[] v) {
			length = v.length;
			long[] l = new long[length], r = new long[length];
			for (int level = MAXLOG - 1; level >= 0; level--) {
				matrix[level] = new SuccinctIndexableDictionary(length + 1);
				int left = 0, right = 0;
				for (int i = 0; i < length; i++) {
					if (1L == (1L & (v[i] >> level))) {
						matrix[level].set(i);
						r[right++] = v[i];
					} else {
						l[left++] = v[i];
					}
				}
				mid[level] = left;
				matrix[level].build();
				long[] tmp = v;
				v = l;
				l = tmp;
				System.arraycopy(r, 0, v, left, right);
			}
		}

		Data succ(boolean f, int l, int r, int level) {
			return new Data(matrix[level].rank(f, l) + (f ? mid[level] : 0),
					matrix[level].rank(f, r) + (f ? mid[level] : 0));
		}

		@SuppressWarnings("unused")
		long access(int k) {
			long result = 0L;
			for (int level = MAXLOG - 1; level >= 0; level--) {
				boolean f = matrix[level].get(k);
				if (f) {
					result |= 1L << level;
				}
				k = matrix[level].rank(f, k) + (f ? mid[level] : 0);
			}
			return result;
		}

		@SuppressWarnings("unused")
		int rank(long x, int r) {
			int l = 0;
			for (int level = MAXLOG - 1; level >= 0; level--) {
				Data data = succ(1 == ((x >> level) & 1), l, r, level);
				l = data.a;
				r = data.b;
			}
			return r - l;
		}

		/**
		 * k-th(0-indexed) smallest number in v[l,r)
		 *
		 * @param l
		 * @param r
		 * @param k
		 * @return k-th(0-indexed) smallest number in v[l,r)
		 */
		long kthSmallest(int l, int r, int k) {
			long result = 0L;
			for (int level = MAXLOG - 1; level >= 0; level--) {
				int count = matrix[level].rank(false, r) - matrix[level].rank(false, l);
				boolean f = (count <= k);
				if (f) {
					result |= 1L << level;
					k -= count;
				}
				Data data = succ(f, l, r, level);
				l = data.a;
				r = data.b;
			}
			return result;
		}

		/**
		 * k-th(0-indexed) largest number in v[l,r)
		 *
		 * @param l
		 * @param r
		 * @param k
		 * @return k-th(0-indexed) largest number in v[l,r)
		 */
		long kthLargest(int l, int r, int k) {
			return kthSmallest(l, r, r - l - k - 1);
		}

		/**
		 * count i s.t. (l <= i < r) && (v[i] < upper)
		 *
		 * @param l
		 * @param r
		 * @param upper
		 * @return count of i s.t. (l <= i < r) && (v[i] < upper)
		 */
		int rangeFreq(int l, int r, long upper) {
			int result = 0;
			for (int level = MAXLOG - 1; level >= 0; level--) {
				boolean f = (1 == ((upper >> level) & 1));
				if (f) {
					result += matrix[level].rank(false, r) - matrix[level].rank(false, l);
				}
				Data data = succ(f, l, r, level);
				l = data.a;
				r = data.b;
			}
			return result;
		}

		/**
		 * count i s.t. (l <= i < r) && (lower <= v[i] < upper)
		 *
		 * @param l
		 * @param r
		 * @param lower
		 * @param upper
		 * @return count of i s.t. (l <= i < r) && (lower <= v[i] < upper)
		 */
		@SuppressWarnings("unused")
		int rangeFreq(int l, int r, long lower, long upper) {
			return rangeFreq(l, r, upper) - rangeFreq(l, r, lower);
		}

		/**
		 * max v[i] s.t. (l <= i < r) && (v[i] < upper)
		 *
		 * @param l
		 * @param r
		 * @param upper
		 * @return max v[i] s.t. (l <= i < r) && (v[i] < upper)
		 */
		@SuppressWarnings("unused")
		long prevValue(int l, int r, long upper) {
			int count = rangeFreq(l, r, upper);
			return (0 == count) ? -1L : kthSmallest(l, r, count - 1);
		}

		/**
		 * min v[i] s.t. (l <= i < r) && (lower <= v[i])
		 *
		 * @param l
		 * @param r
		 * @param lower
		 * @return min v[i] s.t. (l <= i < r) && (lower <= v[i])
		 */
		@SuppressWarnings("unused")
		long nextValue(int l, int r, long lower) {
			int count = rangeFreq(l, r, lower);
			return (r - l == count) ? -1L : kthSmallest(l, r, count);
		}
	}

	private static class SuccinctIndexableDictionary {
		private static final int MASK = 31;
		private static final int BITS = 5;
		int length, blocks;
		int[] bit, sum;

		SuccinctIndexableDictionary(int length) {
			this.length = length;
			blocks = (length + MASK) >> BITS;
			bit = new int[blocks];
			Arrays.fill(bit, 0);
			sum = new int[blocks];
			Arrays.fill(sum, 0);
		}

		void set(int k) {
			bit[k >> BITS] |= 1 << (k & MASK);
		}

		void build() {
			sum[0] = 0;
			IntStream.range(1, blocks).forEach(i -> sum[i] = sum[i - 1] + Integer.bitCount(bit[i - 1]));
		}

		boolean get(int k) {
			return 1 == ((bit[k >> BITS] >> (k & MASK)) & 1);
		}

		int rank(int k) {
			return sum[k >> BITS] + Integer.bitCount(bit[k >> BITS] & ((1 << (k & MASK)) - 1));
		}

		int rank(boolean value, int k) {
			return value ? rank(k) : k - rank(k);
		}

		int select(boolean value, int k) {
			if ((k < 0) || (rank(value, length) <= k)) {
				return -1;
			}
			int low = 0, high = length;
			while (high > low + 1) {
				int mid = (low + high) >> 1;
				if (rank(value, mid) >= k + 1) {
					high = mid;
				} else {
					low = mid;
				}
			}
			return high - 1;
		}

		@SuppressWarnings("unused")
		int select(boolean value, int i, int l) {
			return select(value, i + rank(value, l));
		}
	}
}
