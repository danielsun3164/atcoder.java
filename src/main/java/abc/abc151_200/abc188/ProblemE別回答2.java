package abc.abc151_200.abc188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード（解法2）
 */
public class ProblemE別回答2 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			@SuppressWarnings("unchecked")
			List<Integer>[] childrens = new List[n];
			IntStream.range(0, n).forEach(i -> childrens[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> childrens[scanner.nextInt() - 1].add(scanner.nextInt() - 1));
			/** dp[i]はi番目の町で売った場合の最大利益 */
			int[] dp = new int[n];
			Arrays.fill(dp, -INF);
			Queue<Data> queue = new PriorityQueue<>((x, y) -> Integer.compare(x.a, y.a));
			IntStream.range(0, n).forEach(i -> childrens[i].stream().forEach(j -> queue.add(new Data(a[i], j))));
			while (!queue.isEmpty()) {
				Data data = queue.poll();
				if (-INF == dp[data.i]) {
					dp[data.i] = a[data.i] - data.a;
					for (int j : childrens[data.i]) {
						queue.add(new Data(data.a, j));
					}
				}
			}
			System.out.println(Arrays.stream(dp).max().getAsInt());
		}
	}

	/**
	 * 買った価格、町の番号を表すクラス
	 */
	private static class Data {
		/** 買った価格 */
		int a;
		/** 町の番号 */
		int i;

		Data(int a, int i) {
			super();
			this.a = a;
			this.i = i;
		}
	}
}
