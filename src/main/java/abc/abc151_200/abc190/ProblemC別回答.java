package abc.abc151_200.abc190;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[m], b = new int[m];
			IntStream.range(0, m).forEach(i -> {
				a[i] = scanner.nextInt() - 1;
				b[i] = scanner.nextInt() - 1;
			});
			int k = scanner.nextInt();
			int[] c = new int[k], d = new int[k];
			IntStream.range(0, k).forEach(i -> {
				c[i] = scanner.nextInt() - 1;
				d[i] = scanner.nextInt() - 1;
			});
			int[] count = new int[n];
			System.out.println(IntStream.range(0, 1 << k).map(i -> {
				Arrays.fill(count, 0);
				IntStream.range(0, k).forEach(j -> {
					count[((i & (1 << j)) > 0) ? c[j] : d[j]]++;
				});
				return (int) IntStream.range(0, m).filter(j -> (count[a[j]] > 0) && (count[b[j]] > 0)).count();
			}).max().getAsInt());
		}
	}
}
