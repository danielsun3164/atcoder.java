package other.past201912open;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** フォロー */
	private static final int FOLLOW = 1;
	/** フォロー全返し */
	private static final int FOLLOW_BACK_ALL = 2;
	/** フォローフォロー */
	private static final int FOLLOW_FOLLOW = 3;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			boolean[][] follow = new boolean[n][n];
			IntStream.range(0, q).forEach(i -> {
				int s = scanner.nextInt(), a = scanner.nextInt() - 1;
				if (FOLLOW == s) {
					int b = scanner.nextInt() - 1;
					follow[a][b] = true;
				} else if (FOLLOW_BACK_ALL == s) {
					IntStream.range(0, n).filter(j -> follow[j][a]).forEach(j -> follow[a][j] = true);
				} else if (FOLLOW_FOLLOW == s) {
					boolean[] temp = Arrays.copyOf(follow[a], n);
					IntStream.range(0, n).filter(j -> temp[j]).forEach(j -> IntStream.range(0, n)
							.filter(k -> follow[j][k] && (a != k)).forEach(k -> follow[a][k] = true));
				}
			});
			IntStream.range(0, n).forEach(i -> {
				IntStream.range(0, n).forEach(j -> System.out.print(follow[i][j] ? "Y" : "N"));
				System.out.println();
			});
		}
	}
}
