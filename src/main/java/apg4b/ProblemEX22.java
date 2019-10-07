package apg4b;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX22 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = new Data[n];
			IntStream.range(0, n).forEach(i -> datas[i] = new Data(scanner.nextInt(), scanner.nextInt()));
			Arrays.sort(datas);
			Arrays.stream(datas).forEach(System.out::println);
		}
	}

	/**
	 * aとbのセットを保存するクラス
	 */
	private static class Data implements Comparable<Data> {
		int a;
		int b;

		Data(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Data o) {
			return this.b - o.b;
		}

		@Override
		public String toString() {
			return a + " " + b;
		}
	}
}