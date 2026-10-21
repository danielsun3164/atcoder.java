package abc.abc201_250.abc246;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://drken1215.hatenablog.com/entry/2024/08/03/014609 の実装
 */
public class ProblemA別回答 {

	private static final int N = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int[] x = new int[N], y = new int[N];
			IntStream.range(0, N).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			System.out.println(Arrays.stream(x).reduce(0, (s, xi) -> s ^ xi) + " "
					+ Arrays.stream(y).reduce(0, (s, yi) -> s ^ yi));
		}
	}
}
