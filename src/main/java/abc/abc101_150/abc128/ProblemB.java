package abc.abc101_150.abc128;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.next(), scanner.nextInt(), i)).sorted()
					.toArray(Data[]::new);
			int[] result = new int[n];
			IntStream.range(0, n).forEach(i -> result[i] = datas[i].index + 1);
			Arrays.stream(result).forEach(System.out::println);
		}
	}

	/**
	 * sとpとindexを表すクラス
	 */
	private static class Data implements Comparable<Data> {
		String s;
		int p, index;

		Data(String s, int p, int index) {
			this.s = s;
			this.p = p;
			this.index = index;
		}

		@Override
		public int compareTo(Data data) {
			if (s.equals(data.s)) {
				return Integer.compare(data.p, p);
			}
			return s.compareTo(data.s);
		}
	}
}
