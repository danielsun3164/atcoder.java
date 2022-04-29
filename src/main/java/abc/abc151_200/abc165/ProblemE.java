package abc.abc151_200.abc165;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int t = scanner.nextInt(), m = scanner.nextInt();
			int n = 2 * m + 1, diff = 1 - (m & 1);
			int[][] a = new int[m][2];
			IntStream.range(0, n / 4).forEach(i -> {
				a[i][0] = i + 1;
				a[i][1] = n / 2 - i + diff;
			});
			IntStream.range(n / 4, n / 2).forEach(i -> {
				a[i][0] = i + n / 4 + 2;
				a[i][1] = n - (i - n / 4);
			});
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, m)
					.forEach(i -> sb.append(a[i][0]).append(" ").append(a[i][1]).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
