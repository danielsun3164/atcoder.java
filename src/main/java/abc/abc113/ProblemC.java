package abc.abc113;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			Set<Data>[] prefectures = new Set[n];
			IntStream.range(0, n).forEach(i -> prefectures[i] = new TreeSet<>());
			IntStream.range(0, m).forEach(i -> {
				int p = scanner.nextInt() - 1, y = scanner.nextInt();
				prefectures[p].add(new Data(i, y));
			});
			String[] result = new String[m];
			IntStream.range(0, n).forEach(i -> {
				int index = 1;
				for (Data data : prefectures[i]) {
					result[data.index] = String.format("%06d%06d", (i + 1), index);
					index++;
				}
			});
			Arrays.stream(result).forEach(System.out::println);
		}
	}

	/**
	 * indexとyを表すクラス
	 */
	private static class Data implements Comparable<Data> {
		/** 番号 */
		int index;
		/** 誕生した年数 */
		int y;

		Data(int index, int y) {
			super();
			this.index = index;
			this.y = y;
		}

		@Override
		public int compareTo(Data data) {
			return Integer.compare(y, data.y);
		}
	}
}
