package abc.abc151_200.abc190;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], b = new int[m];
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
			});
			int k = scanner.nextInt();
			int[] c = new int[k], d = new int[k];
			IntStream.range(0, k).forEach(i -> {
				c[i] = scanner.nextInt() - 1;
				d[i] = scanner.nextInt() - 1;
			});
			int[] count = new int[n];
			Arrays.fill(count, 0);
			System.out.println(getResult(0, m, a, b, k, c, d, count));
		}
	}

	/**
	 * 満たされる条件の最大個数を計算する
	 * 
	 * @param now   現在処理中の人
	 * @param m     条件の数
	 * @param a     条件aの配列
	 * @param b     条件bの配列
	 * @param k     人数
	 * @param c     cの配列
	 * @param d     dの配列
	 * @param count 皿にあるボールの数
	 * @return 満たされる条件の最大個数
	 */
	private static int getResult(int now, int m, int[] a, int[] b, int k, int[] c, int[] d, int[] count) {
		if (now == k) {
			return (int) IntStream.range(0, m).filter(i -> (count[a[i]] > 0) && (count[b[i]] > 0)).count();
		}
		if (count[c[now]] > 0) {
			count[d[now]]++;
			int r = getResult(now + 1, m, a, b, k, c, d, count);
			count[d[now]]--;
			return r;
		} else if (count[d[now]] > 0) {
			count[c[now]]++;
			int r = getResult(now + 1, m, a, b, k, c, d, count);
			count[c[now]]--;
			return r;
		} else {
			count[c[now]]++;
			int rc = getResult(now + 1, m, a, b, k, c, d, count);
			count[c[now]]--;
			count[d[now]]++;
			int rd = getResult(now + 1, m, a, b, k, c, d, count);
			count[d[now]]--;
			return Math.max(rc, rd);
		}
	}
}
