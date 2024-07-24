package abc.abc201_250.abc230;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ProblemC {

	/** 白マスを表す文字 */
	private static final char WHITE = '.';
	/** 黒マスを表す文字 */
	private static final char BLACK = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong(), a = scanner.nextLong(), b = scanner.nextLong(), p = scanner.nextLong(),
					q = scanner.nextLong(), r = scanner.nextLong(), s = scanner.nextLong();
			int h = (int) (q - p + 1), w = (int) (s - r + 1);
			char[][] answer = new char[h][w];
			IntStream.range(0, h).forEach(i -> Arrays.fill(answer[i], WHITE));
			LongStream.rangeClosed(Math.max(p - a, Math.max(1 - a, 1 - b)), Math.min(q - a, Math.min(n - a, n - b)))
					.filter(k -> ((b + k) >= r) && ((b + k) <= s))
					.forEach(k -> answer[(int) (a + k - p)][(int) (b + k - r)] = BLACK);
			LongStream.rangeClosed(Math.max(p - a, Math.max(1 - a, b - n)), Math.min(q - a, Math.min(n - a, b - 1)))
					.filter(k -> ((b - k) >= r) && ((b - k) <= s))
					.forEach(k -> answer[(int) (a + k - p)][(int) (b - k - r)] = BLACK);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
