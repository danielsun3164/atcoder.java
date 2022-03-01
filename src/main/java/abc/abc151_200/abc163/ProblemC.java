package abc.abc151_200.abc163;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] s = new int[n];
			Arrays.fill(s, 0);
			IntStream.range(1, n).forEach(i -> s[scanner.nextInt() - 1]++);
			// TLE対策のため、結果をStringBuilderへ入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(s).forEach(si -> sb.append(si).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
