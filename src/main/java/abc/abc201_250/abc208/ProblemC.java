package abc.abc201_250.abc208;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long k = scanner.nextLong();
			Data[] datas = IntStream.range(0, n).mapToObj(i -> new Data(scanner.nextInt(), i))
					.sorted((a, b) -> Integer.compare(a.a, b.a)).toArray(Data[]::new);
			long[] answer = new long[n];
			Arrays.fill(answer, k / n);
			k %= n;
			IntStream.range(0, (int) k).forEach(i -> answer[datas[i].index]++);
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ans -> sb.append(ans).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * aとindexを格納するクラス
	 */
	private static class Data {
		int a, index;

		Data(int a, int index) {
			this.a = a;
			this.index = index;
		}
	}
}
