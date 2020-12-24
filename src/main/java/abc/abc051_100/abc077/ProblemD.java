package abc.abc051_100.abc077;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * https://atcoder.jp/contests/abc077/submissions/1745942 を参考に実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();

			// 計算結果を保存する配列
			long[] result = new long[k];
			Arrays.fill(result, Long.MAX_VALUE >> 1);

			Deque<Data> deque = new ArrayDeque<>();
			deque.add(new Data(1, 1L));

			while (deque.size() > 0) {
				Data data = deque.poll();
				if (result[data.m] > data.c) {
					result[data.m] = data.c;
					deque.addLast(new Data((data.m + 1) % k, data.c + 1));
					deque.addFirst(new Data((data.m * 10) % k, data.c));
				}
			}
			System.out.println(result[0]);
		}
	}

	/**
	 * データを格納するクラス
	 */
	private static class Data implements Comparable<Data> {
		/** 入力数字 */
		int m;
		/** 計算結果 */
		long c;

		/**
		 * コンストラクタ
		 * 
		 * @param m 入力数字
		 * @param c 計算結果
		 */
		Data(int m, long c) {
			super();
			this.m = m;
			this.c = c;
		}

		/**
		 * dataと比較した結果を返す
		 * 
		 * @param data 比較対象データ
		 * @return dataと比較した結果
		 */
		@Override
		public int compareTo(Data data) {
			return Long.compare(c, data.c);
		}
	}
}
