package abc.abc101_150.abc147;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 *
 * https://atcoder.jp/contests/abc147/submissions/8857113 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long x = scanner.nextLong(), d = scanner.nextLong();
			if (0L == d) {
				System.out.println((0L == x) ? 1 : (n + 1));
				return;
			}
			if (d < 0L) {
				d = -d;
				x = -x;
			}
			Data[] datas = new Data[n + 1];
			for (int i = 0; i <= n; i++) {
				long l = (i * (long) (i - 1)) / 2L, r = (i * (long) (n - 1)) - l;
				long m = i * x;
				long pl = m / d, md = m % d;
				if (md < 0) {
					md += d;
					pl--;
				}
				l += pl;
				r += pl;
				datas[i] = new Data(md, l, r + 1);
			}
			Arrays.sort(datas, (a, b) -> (a.md == b.md) ? Long.compare(a.l, b.l) : Long.compare(a.md, b.md));
			long answer = 0L;
			for (int i = 0; i <= n;) {
				int j = i;
				long la = Long.MIN_VALUE;
				while ((j <= n) && (datas[i].md == datas[j].md)) {
					la = Math.max(la, datas[j].l);
					answer += Math.max(0L, datas[j].r - la);
					la = Math.max(la, datas[j].r);
					j++;
				}
				i = j;
			}
			System.out.println(answer);
		}
	}

	/**
	 * md,l,rを格納するクラス
	 */
	private static class Data {
		long md, l, r;

		Data(long md, long l, long r) {
			super();
			this.md = md;
			this.l = l;
			this.r = r;
		}
	}
}
