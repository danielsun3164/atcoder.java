package abc.abc080;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int nc = scanner.nextInt();
			int[] s = new int[n], t = new int[n], c = new int[n];
			IntStream.range(0, n).forEach(i -> {
				s[i] = scanner.nextInt();
				t[i] = scanner.nextInt();
				c[i] = scanner.nextInt() - 1;
			});
			int maxT = Arrays.stream(t).max().getAsInt();
			int[][] channel = new int[nc][maxT * 2 + 2];
			IntStream.range(0, nc).forEach(i -> Arrays.fill(channel[i], 0));
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(channel[c[i]], s[i] * 2, t[i] * 2 + 1, 1);
			});
			System.out.println(IntStream.range(0, maxT * 2 + 2)
					.map(i -> IntStream.range(0, nc).map(j -> channel[j][i]).sum()).max().getAsInt());
		}
	}
}
