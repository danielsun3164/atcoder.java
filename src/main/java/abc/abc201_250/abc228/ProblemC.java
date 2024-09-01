package abc.abc201_250.abc228;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	/** 3日間 */
	private static final int N = 3;
	/** 試験の満点 */
	private static final int MAX = 300;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] p = new int[n], s = new int[n];
			IntStream.range(0, n).forEach(i -> p[i] = s[i] = IntStream.range(0, N).map(j -> scanner.nextInt()).sum());
			Arrays.sort(s);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n)
					.forEach(i -> sb.append((p[i] + MAX >= s[n - k]) ? "Yes" : "No").append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
