package abc.abc201_250.abc228;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc228/editorial/2945 の実装<br/>
 * https://atcoder.jp/contests/abc228/submissions/33384331 にも参考
 */
public class ProblemF {

	/** 最大値 */
	private static final long INF = Long.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt(), h1 = scanner.nextInt(), w1 = scanner.nextInt(),
					hh2 = scanner.nextInt(), ww2 = scanner.nextInt();
			long[][] a = IntStream.range(0, h)
					.mapToObj(i -> IntStream.range(0, w).mapToLong(j -> scanner.nextLong()).toArray())
					.toArray(long[][]::new);
			if ((hh2 >= h1) && (ww2 >= w1)) {
				System.out.println(0);
				return;
			}
			long[][] sum = new long[h + 1][w + 1];
			IntStream.rangeClosed(0, h).forEach(i -> Arrays.fill(sum[i], 0L));
			IntStream.range(0, h).forEach(i -> IntStream.range(0, w)
					.forEach(j -> sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + a[i][j]));
			int h2 = Math.min(h1, hh2), w2 = Math.min(w1, ww2);
			long[][] aoki = new long[h + 1][w + 1];
			IntStream.rangeClosed(0, h).forEach(i -> Arrays.fill(aoki[i], 0L));
			IntStream.rangeClosed(0, h - h2).forEach(i -> IntStream.rangeClosed(0, w - w2)
					.forEach(j -> aoki[i][j] = sum[i + h2][j + w2] - sum[i + h2][j] - sum[i][j + w2] + sum[i][j]));
			int dh = h1 - h2 + 1, dw = w1 - w2 + 1;
			long[][] m = new long[h + 1][w + 1];
			IntStream.rangeClosed(0, h).forEach(i -> Arrays.fill(m[i], 0L));
			Swag swag = new Swag();
			IntStream.range(0, h).forEach(i -> {
				swag.clear();
				IntStream.range(0, dw).forEach(j -> swag.push(aoki[i][j]));
				IntStream.rangeClosed(0, w - dw).forEach(j -> {
					m[i][j] = swag.query();
					swag.push(aoki[i][j + dw]);
					swag.pop();
				});
			});
			long[][] m2 = new long[h + 1][w + 1];
			IntStream.rangeClosed(0, h).forEach(i -> Arrays.fill(m2[i], 0L));
			IntStream.rangeClosed(0, w - dw).forEach(j -> {
				swag.clear();
				IntStream.range(0, dh).forEach(i -> swag.push(m[i][j]));
				IntStream.rangeClosed(0, h - dh).forEach(i -> {
					m2[i][j] = swag.query();
					swag.push(m[i + dh][j]);
					swag.pop();
				});
			});
			System.out.println(IntStream.rangeClosed(0, h - h1).mapToLong(i -> IntStream.rangeClosed(0, w - w1)
					.mapToLong(j -> sum[i + h1][j + w1] - sum[i][j + w1] - sum[i + h1][j] + sum[i][j] - m2[i][j]).max()
					.getAsLong()).max().getAsLong());
		}
	}

	private static class Swag {
		int size = 0;
		Deque<Long> head = new ArrayDeque<>(), tail = new ArrayDeque<>();
		long rsum = ident();

		long ident() {
			return -INF;
		}

		long ope(long x, long y) {
			return Math.max(x, y);
		}

		void push(long x) {
			size++;
			rsum = ope(rsum, x);
			tail.addLast(x);
		}

		void pop() {
			if (0 == size) {
				return;
			}
			if (head.isEmpty()) {
				long sum = ident();
				while (!tail.isEmpty()) {
					sum = ope(tail.pollLast(), sum);
					head.addLast(sum);
				}
				rsum = ident();
			}
			head.removeLast();
			size--;
		}

		long query() {
			long result = rsum;
			if (!head.isEmpty()) {
				result = ope(head.getLast(), result);
			}
			return result;
		}

		void clear() {
			size = 0;
			head.clear();
			tail.clear();
			rsum = ident();
		}
	}
}
