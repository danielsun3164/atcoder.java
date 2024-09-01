package abc.abc201_250.abc228;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/10030 の解説の実装<br/>
 * https://atcoder.jp/contests/abc228/submissions/53518913 にも参考
 */
public class ProblemH別回答 {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			AcData[] ac = IntStream.range(0, n).mapToObj(i -> new AcData(scanner.nextLong(), scanner.nextLong()))
					.sorted((p, q) -> (p.a == q.a) ? Long.compare(p.c, q.c) : Long.compare(p.a, q.a))
					.toArray(AcData[]::new);
			int m = 1;
			while (m - 1 < n) {
				m <<= 1;
			}
			long[] a = new long[n], d = new long[n], sumC = new long[n + 1], sumD = new long[n + 1],
					dp = new long[m + 1];
			Arrays.fill(dp, INF);
			sumC[0] = sumD[0] = dp[0] = 0L;
			IntStream.range(0, n).forEach(i -> {
				a[i] = ac[i].a;
				d[i] = a[i] * ac[i].c;
				sumC[i + 1] = sumC[i] + ac[i].c;
				sumD[i + 1] = sumD[i] + d[i];
			});
			f(n, x, 0, m - 1, dp, a, sumC, sumD);
			System.out.println(dp[n]);
		}
	}

	private static void f(int n, int x, int u, int d, long[] dp, long[] a, long[] sumC, long[] sumD) {
		if (1 == d - u) {
			dp[d] = Math.min(dp[d], c(n, x, u, d, dp, a, sumC, sumD));
			return;
		}
		int md = (u + d) >> 1;
		f(n, x, u, md, dp, a, sumC, sumD);
		Queue<UdlrData> que = new ArrayDeque<>();
		que.add(new UdlrData(md + 1, d + 1, u, md + 1));
		while (!que.isEmpty()) {
			UdlrData data = que.poll();
			int m = (data.u + data.d) >> 1, index = -1;
			long b = INF;
			for (int i = data.l; i < data.r; i++) {
				long nc = c(n, x, i, m, dp, a, sumC, sumD);
				if (b >= nc) {
					b = nc;
					index = i;
				}
			}
			dp[m] = Math.min(dp[m], b);
			if (data.u != m) {
				que.add(new UdlrData(data.u, m, data.l, index + 1));
			}
			if (m + 1 != data.d) {
				que.add(new UdlrData(m + 1, data.d, index, data.r));
			}
		}
		f(n, x, md + 1, d, dp, a, sumC, sumD);
	}

	private static long c(int n, int x, int l, int r, long[] dp, long[] a, long[] sumC, long[] sumD) {
		if ((l >= r) || (r > n)) {
			return INF;
		}
		return dp[l] + a[r - 1] * (sumC[r] - sumC[l]) - (sumD[r] - sumD[l]) + x;
	}

	/**
	 * a,cを格納するクラス
	 */
	private static class AcData {
		long a, c;

		AcData(long a, long c) {
			this.a = a;
			this.c = c;
		}
	}

	/**
	 * u,d,l,rを格納するクラス
	 */
	private static class UdlrData {
		int u, d, l, r;

		UdlrData(int u, int d, int l, int r) {
			this.u = u;
			this.d = d;
			this.l = l;
			this.r = r;
		}
	}
}
