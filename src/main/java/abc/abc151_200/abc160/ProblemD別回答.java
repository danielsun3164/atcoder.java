package abc.abc151_200.abc160;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
			int[] answer = new int[n - 1];
			Arrays.fill(answer, 0);
			IntStream
					.range(0,
							n)
					.forEach(i -> IntStream.range(i + 1, n).forEach(j -> answer[min(Math.abs(i - j),
							Math.abs(x - i) + Math.abs(y - j) + 1, Math.abs(y - i) + Math.abs(x - j) + 1) - 1]++));
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			Arrays.stream(answer).forEach(ai -> sb.append(ai).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * 数列の最小の値を返す
	 *
	 * @param a 数列
	 * @return 数列の最小の値
	 */
	private static int min(int... a) {
		return Arrays.stream(a).min().getAsInt();
	}
}
