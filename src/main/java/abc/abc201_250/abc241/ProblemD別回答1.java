package abc.abc201_250.abc241;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc241/editorial/3499 の実装<br/>
 * https://atcoder.jp/contests/abc241/submissions/29777396 にも参考
 */
public class ProblemD別回答1 {

	/** t==2のときは+1、t==3のときは-1 */
	private static final int[] DX = { 0, 0, 1, -1 };
	/** */
	private static final int THR = 500;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			int[] t = new int[q + 2], k = new int[q + 2];
			long[] x = new long[q + 2];
			Data[] d = new Data[q];
			IntStream.rangeClosed(1, q).forEach(i -> {
				t[i] = scanner.nextInt();
				x[i] = scanner.nextLong();
				if (1 != t[i]) {
					k[i] = scanner.nextInt();
				}
				d[i - 1] = new Data((x[i] << 3) + DX[t[i]], i);
			});
			Arrays.sort(d, (a, b) -> Long.compare(a.key, b.key));
			long[] x2 = new long[q + 2];
			int[] x3 = new int[q + 2];
			IntStream.range(0, q).forEach(i -> {
				x2[i + 1] = x[d[i].id];
				x3[d[i].id] = i + 1;
			});
			x2[0] = x2[q + 1] = -1;
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			int tail = 0, l, r;
			int[] left = new int[q + 2], right = new int[q + 2], q2 = new int[1001], answer = new int[6];
			Arrays.fill(left, 0);
			Arrays.fill(right, q + 1);
			boolean[] flag = new boolean[q + 2];
			Arrays.fill(flag, false);
			for (int i = 1; i <= q; i++) {
				if (1 == t[i]) {
					flag[x3[i]] = true;
					q2[tail++] = x3[i];
					if (THR == tail) {
						tail = 0;
						l = 0;
						for (int j = 1; j <= q; j++) {
							left[j] = l;
							if (flag[j]) {
								l = j;
							}
						}
						r = q + 1;
						for (int j = q; j >= 1; j--) {
							right[j] = r;
							if (flag[j]) {
								r = j;
							}
						}
					}
				} else if (2 == t[i]) {
					l = 1;
					answer[0] = x3[i];
					for (int j = x3[i]; l <= k[i]; j = left[j], l++) {
						answer[l] = left[j];
					}
					l--;
					for (int head = 0; head < tail; head++) {
						if ((answer[l] < q2[head]) && (q2[head] < x3[i])) {
							answer[l] = q2[head];
							for (int j = l; answer[j - 1] < answer[j]; j--) {
								int temp = answer[j - 1];
								answer[j - 1] = answer[j];
								answer[j] = temp;
							}
						}
					}
					sb.append(x2[answer[l]]).append(System.lineSeparator());
				} else {
					r = 1;
					answer[0] = x3[i];
					for (int j = x3[i]; r <= k[i]; j = right[j], r++) {
						answer[r] = right[j];
					}
					r--;
					for (int head = 0; head < tail; head++) {
						if ((x3[i] < q2[head]) && (q2[head] < answer[r])) {
							answer[r] = q2[head];
							for (int j = r; answer[j - 1] > answer[j]; j--) {
								int temp = answer[j - 1];
								answer[j - 1] = answer[j];
								answer[j] = temp;
							}
						}
					}
					sb.append(x2[answer[r]]).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * key,id を格納するクラス
	 */
	private static class Data {
		long key;
		int id;

		Data(long key, int id) {
			super();
			this.key = key;
			this.id = id;
		}
	}
}
