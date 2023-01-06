package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem081 {

	/** AとBの最大値 */
	private static final int MAX = 5_001;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[][] count = new int[MAX + 1][MAX + 1], sum = new int[MAX + 1][MAX + 1];
			IntStream.rangeClosed(0, MAX).forEach(i -> Arrays.fill(count[i], 0));
			IntStream.rangeClosed(0, MAX).forEach(i -> Arrays.fill(sum[i], 0));
			int[] a = new int[n], b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
				count[a[i]][b[i]]++;
			});
			// IntStreamを使用する場合ではバッグが発生するため、for文で実装
			for (int i = 1; i <= MAX; i++) {
				for (int j = 1; j <= MAX; j++) {
					sum[i][j] = sum[i - 1][j] - sum[i - 1][j - 1] + sum[i][j - 1] + count[i][j];
				}
			}
			System.out.println(IntStream.range(0, MAX - k)
					.map(i -> IntStream.range(0, MAX - k)
							.map(j -> sum[i][j] - sum[i + k + 1][j] + sum[i + k + 1][j + k + 1] - sum[i][j + k + 1])
							.max().getAsInt())
					.max().getAsInt());
		}
	}
}
