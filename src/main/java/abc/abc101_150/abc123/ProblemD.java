package abc.abc101_150.abc123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), y = scanner.nextInt(), z = scanner.nextInt(), k = scanner.nextInt();
			long[] a = IntStream.range(0, x).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			long[] b = IntStream.range(0, y).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			long[] c = IntStream.range(0, z).mapToLong(i -> scanner.nextLong()).sorted().toArray();
			long[] sum = new long[k];
			Queue<Sum> queue = new PriorityQueue<>((s1, s2) -> Long.compare(s2.sum, s1.sum));
			Set<Sum> set = new HashSet<>();
			Sum first = new Sum(a[x - 1] + b[y - 1] + c[z - 1], x - 1, y - 1, z - 1);
			queue.add(first);
			set.add(first);
			for (int j = 0; j < k; j++) {
				Sum now = queue.poll();
				sum[j] = now.sum;
				if (now.ia > 0) {
					Sum sum1 = new Sum(a[now.ia - 1] + b[now.ib] + c[now.ic], now.ia - 1, now.ib, now.ic);
					if (!set.contains(sum1)) {
						queue.add(sum1);
						set.add(sum1);
					}
				}
				if (now.ib > 0) {
					Sum sum2 = new Sum(a[now.ia] + b[now.ib - 1] + c[now.ic], now.ia, now.ib - 1, now.ic);
					if (!set.contains(sum2)) {
						queue.add(sum2);
						set.add(sum2);
					}
				}
				if (now.ic > 0) {
					Sum sum3 = new Sum(a[now.ia] + b[now.ib] + c[now.ic - 1], now.ia, now.ib, now.ic - 1);
					if (!set.contains(sum3)) {
						queue.add(sum3);
						set.add(sum3);
					}
				}
			}
			Arrays.stream(sum).forEach(System.out::println);
		}
	}

	/**
	 * sum,ia,ib,icを表すクラス
	 */
	private static class Sum {
		long sum;
		int ia;
		int ib;
		int ic;

		Sum(long sum, int ia, int ib, int ic) {
			super();
			this.sum = sum;
			this.ia = ia;
			this.ib = ib;
			this.ic = ic;
		}

		@Override
		public int hashCode() {
			return Objects.hash(sum, ia, ib, ic);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Sum) {
				Sum sum2 = (Sum) obj;
				return (sum == sum2.sum) && (ia == sum2.ia) && (ib == sum2.ib) && (ic == sum2.ic);
			}
			return false;
		}
	}
}
