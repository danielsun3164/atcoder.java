package abc061;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			Data[] datas = new Data[n];
			IntStream.range(0, n).forEach(i -> datas[i] = new Data(scanner.nextInt(), scanner.nextInt()));
			Arrays.sort(datas);
			for (Data data : datas) {
				k -= data.count;
				if (k <= 0) {
					System.out.println(data.number);
					return;
				}
			}
		}
	}

	/**
	 * 数字と個数を格納するクラス
	 */
	private static class Data implements Comparable<Data> {

		/** 数字 */
		int number;
		/** 個数 */
		int count;

		Data(int number, int count) {
			super();
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(Data o) {
			return number - o.number;
		}
	}
}
