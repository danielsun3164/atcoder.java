package abc.abc101_150.abc113;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りの計算方法で実装
 */
public class ProblemB {

	/** 平均気温の係数 */
	private static final int D = 6;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), t = scanner.nextInt() * 1000, a = scanner.nextInt() * 1000;
			Queue<Data> queue = new PriorityQueue<>();
			IntStream.range(0, n).forEach(i -> {
				int h = scanner.nextInt();
				queue.add(new Data(i + 1, Math.abs(t - h * D - a)));
			});
			System.out.println(queue.peek().index);
		}
	}

	/**
	 * 番号と平均気温を表すクラス
	 */
	private static class Data implements Comparable<Data> {
		/** 番号 */
		int index;
		/** 平均気温 */
		double t;

		Data(int index, double t) {
			super();
			this.index = index;
			this.t = t;
		}

		@Override
		public int compareTo(Data data) {
			return Double.compare(t, data.t);
		}
	}
}
