package abc.abc201_250.abc223;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc223/editorial/2784 の解説の実装<br/>
 * https://atcoder.jp/contests/abc223/submissions/26990597 にも参考
 */
public class ProblemH別回答2 {

	/** 数字の２進数桁数 */
	private static final int N = 60;
	/** */
	private static final int B = 46;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			int[] l = new int[q], r = new int[q];
			long[] x = new long[q];
			IntStream.range(0, q).forEach(i -> {
				l[i] = scanner.nextInt() - 1;
				r[i] = scanner.nextInt() - 1;
				x[i] = scanner.nextLong();
			});
			BinaryMat[] big = new BinaryMat[n / B + 1];
			IntStream.range(0, big.length).forEach(i -> big[i] = new BinaryMat());
			IntStream.range(0, big.length).forEach(i -> {
				int s = i * B, t = Math.min((i + 1) * B, n);
				big[i] = new BinaryMat();
				IntStream.range(s, t).forEach(j -> big[i].add(a[j]));
			});
			SparseTable spt = new SparseTable(big);
			BinaryMat[][] accR = new BinaryMat[n / B + 1][B + 1], accL = new BinaryMat[n / B + 1][B + 1];
			IntStream.range(0, n / B + 1).forEach(i -> {
				int s = i * B, t = Math.min((i + 1) * B, n);
				accR[i][0] = new BinaryMat();
				IntStream.range(s, t).forEach(j -> {
					accR[i][j - i * B + 1] = accR[i][j - i * B].clone();
					accR[i][j - i * B + 1].add(a[j]);
				});
				accL[i][t - i * B] = new BinaryMat();
				IntStream.range(s, t).map(j -> s + t - j - 1).forEach(j -> {
					accL[i][j - i * B] = accL[i][j - i * B + 1].clone();
					accL[i][j - i * B].add(a[j]);
				});
			});
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, q).forEach(i -> {
				int lb = (l[i] + B - 1) / B, rb = r[i] / B;
				BinaryMat mat;
				if (lb >= rb) {
					mat = new BinaryMat();
					for (int j = l[i]; j <= r[i]; j++) {
						mat.add(a[j]);
					}
				} else {
					mat = spt.query(lb, rb - 1);
					if (lb > 0) {
						mat = merge(mat, accL[lb - 1][l[i] + B - lb * B]);
					}
					mat = merge(mat, accR[rb][r[i] - rb * B]);
				}
				sb.append(mat.isIndependent(x[i]) ? "No" : "Yes").append(System.lineSeparator());
			});
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	private static BinaryMat merge(BinaryMat a, BinaryMat b) {
		if (N == a.rank()) {
			return a.clone();
		}
		if (N == b.rank()) {
			return b.clone();
		}
		BinaryMat result = a.clone();
		for (long v : b.basis) {
			result.add(v);
		}
		return result;
	}

	private static class BinaryMat implements Cloneable {
		List<Long> basis = new ArrayList<>();

		long sift(long x) {
			for (long b : basis) {
				x = Math.min(x, x ^ b);
				if (0L == x) {
					return 0L;
				}
			}
			return x;
		}

		void add(long x) {
			long xSifted = sift(x);
			if (0L != xSifted) {
				basis.add(xSifted);
			}
		}

		int rank() {
			return basis.size();
		}

		boolean isIndependent(long x) {
			return 0L != sift(x);
		}

		@Override
		protected BinaryMat clone() {
			BinaryMat mat = new BinaryMat();
			mat.basis.addAll(basis);
			return mat;
		}
	}

	private static class SparseTable {
		BinaryMat[][] st;

		SparseTable(BinaryMat[] big) {
			int n = big.length, h = 1;
			while ((1 << h) < n) {
				h++;
			}
			st = new BinaryMat[h + 1][n];
			System.arraycopy(big, 0, st[0], 0, n);
			for (int b = 1; b <= h; b++) {
				if ((n + 1) < (1 << b)) {
					break;
				}
				for (int i = 0; i <= n - (1 << b); i++) {
					st[b][i] = merge(st[b - 1][i], st[b - 1][(1 << (b - 1)) + i]);
				}
			}
		}

		int topBit(int t) {
			return Integer.SIZE - 1 - Integer.numberOfLeadingZeros(t);
		}

		BinaryMat query(int f, int s) {
			int b = topBit(s + 1 - f), endPoint = s + 1 - (1 << b);
			return merge(st[b][f], st[b][endPoint]);
		}
	}
}
