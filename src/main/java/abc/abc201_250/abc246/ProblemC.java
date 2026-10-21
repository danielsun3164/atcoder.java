package abc.abc201_250.abc246;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt(), x = scanner.nextInt();
			int[] a = new int[n];
			int aMax = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).max().getAsInt();
			if (Arrays.stream(a).asLongStream().map(ai -> (ai + x - 1) / x).sum() <= k) {
				System.out.println(0);
				return;
			}
			if (k > n) {
				int ng = 0, ok = aMax;
				while (ng + 1 < ok) {
					int med = (ng + ok) / 2;
					if (ok(a, k, x, med)) {
						ok = med;
					} else {
						ng = med;
					}
				}
				k -= calc(a, x, ok);
			}
			Queue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
			IntStream.range(0, n).forEach(i -> que.add(a[i]));
			while (k > 0) {
				k--;
				int ai = que.poll();
				if (0 == ai) {
					break;
				}
				que.add(Math.max(ai - x, 0));
			}
			System.out.println(que.stream().mapToLong(Integer::longValue).sum());
		}
	}

	/**
	 * k枚以下のクーポンを使って、すべての商品をv円以下で買えるかどうかを判定する
	 *
	 * @param a 商品値段の配列
	 * @param k クーポン数
	 * @param x クーポンの割引額
	 * @param v 目標金額
	 * @return k枚以下のクーポンを使って、すべての商品をv円以下で買えるかどうか
	 */
	private static boolean ok(int[] a, int k, int x, int v) {
		return Arrays.stream(a).mapToLong(ai -> (ai <= v) ? 0L : (ai - v + x - 1) / x).sum() <= k;
	}

	/**
	 * すべての商品をv円以下で買う場合使うクーポン券の合計枚数を計算する
	 *
	 * @param a 商品値段の配列（処理後はすべてv円以下になる）
	 * @param x クーポンの割引額
	 * @param v 目標金額
	 * @return すべての商品をv円以下で買う場合使うクーポン券の合計枚数
	 */
	private static int calc(int[] a, int x, int v) {
		return IntStream.range(0, a.length).map(i -> {
			if (a[i] <= v) {
				return 0;
			} else {
				int ki = (a[i] - v + x - 1) / x;
				a[i] = Math.max(a[i] - ki * x, 0);
				return ki;
			}
		}).sum();
	}
}
