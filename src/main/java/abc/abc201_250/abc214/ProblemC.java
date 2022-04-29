package abc.abc201_250.abc214;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] s = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] t = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long[] answer = IntStream.range(0, n).mapToLong(i -> t[i]).toArray();
			IntStream.range(0, 2 * n)
					.forEach(i -> answer[(i + 1) % n] = Math.min(answer[(i + 1) % n], answer[i % n] + s[i % n]));
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n).forEach(i -> sb.append(answer[i]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
