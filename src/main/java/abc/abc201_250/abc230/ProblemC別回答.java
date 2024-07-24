package abc.abc201_250.abc230;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * https://atcoder.jp/contests/abc230/editorial/3014 の別解の実装
 */
public class ProblemC別回答 {

	/** 白マスを表す文字 */
	private static final char WHITE = '.';
	/** 黒マスを表す文字 */
	private static final char BLACK = '#';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			long n = scanner.nextLong(), a = scanner.nextLong(), b = scanner.nextLong(), p = scanner.nextLong(),
					q = scanner.nextLong(), r = scanner.nextLong(), s = scanner.nextLong();
			int h = (int) (q - p + 1), w = (int) (s - r + 1);
			char[][] answer = new char[h][w];
			LongStream.rangeClosed(p, q)
					.forEach(i -> LongStream.rangeClosed(r, s)
							.forEach(j -> answer[(int) (i - p)][(int) (j - r)] = ((i - j == a - b) || (i + j == a + b))
									? BLACK
									: WHITE));
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
