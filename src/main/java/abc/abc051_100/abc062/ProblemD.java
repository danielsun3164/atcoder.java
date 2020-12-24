package abc.abc051_100.abc062;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, 3 * n).map(i -> scanner.nextInt()).toArray();
			// それぞれ前半と後半の計算結果
			long[] result1 = new long[n + 1], result2 = new long[n + 1];
			// 前半の計算用
			Queue<Integer> minQueue = new PriorityQueue<>((x, y) -> x.compareTo(y));
			result1[0] = IntStream.range(0, n).mapToLong(i -> (long) a[i]).sum();
			// 後半の計算用
			Queue<Integer> maxQueue = new PriorityQueue<>((x, y) -> y.compareTo(x));
			result2[n] = IntStream.range(2 * n, 3 * n).mapToLong(i -> (long) a[i]).sum();
			IntStream.range(0, n).forEach(i -> {
				minQueue.add(a[i]);
				maxQueue.add(a[3 * n - i - 1]);
			});
			IntStream.rangeClosed(1, n).forEach(i -> {
				// 前半の計算
				minQueue.add(a[n + i - 1]);
				result1[i] = result1[i - 1] + a[n + i - 1] - minQueue.poll();
				// 後半の計算
				maxQueue.add(a[n + n - i]);
				result2[n - i] = result2[n - i + 1] + a[n + n - i] - maxQueue.poll();
			});
			System.out.println(IntStream.rangeClosed(0, n).mapToLong(i -> result1[i] - result2[i]).max().getAsLong());
		}
	}
}
