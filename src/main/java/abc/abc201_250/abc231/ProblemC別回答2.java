package abc.abc201_250.abc231;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC別回答2 {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			Data[] ax = new Data[n + q];
			IntStream.range(0, n).forEach(i -> ax[i] = new Data(scanner.nextInt(), INF));
			IntStream.range(0, q).forEach(i -> ax[n + i] = new Data(scanner.nextInt(), i));
			Arrays.sort(ax, (x, y) -> (x.value == y.value) ? Integer.compare(y.index, x.index)
					: Integer.compare(y.value, x.value));
			int[] answer = new int[q];
			int count = 0;
			for (Data data : ax) {
				if (data.index < q) {
					answer[data.index] = count;
				} else {
					count++;
				}
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			for (int ai : answer) {
				sb.append(ai).append(System.lineSeparator());
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * value, indexを格納するクラス
	 */
	private static class Data {
		int value, index;

		Data(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
