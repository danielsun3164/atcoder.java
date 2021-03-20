package other.joi2008yo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemE {

	/** 表 */
	private static final int HEAD = 0;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt(), c = scanner.nextInt();
			boolean[][] a = new boolean[r][c];
			IntStream.range(0, r)
					.forEach(i -> IntStream.range(0, c).forEach(j -> a[i][j] = (HEAD == scanner.nextInt())));
			System.out.println(IntStream.range(0, 1 << r).map(i -> {
				boolean[][] b = new boolean[r][];
				IntStream.range(0, r).forEach(j -> b[j] = a[j].clone());
				IntStream.range(0, r).filter(j -> (i & (1 << j)) > 0)
						.forEach(j -> IntStream.range(0, c).forEach(k -> b[j][k] = !b[j][k]));
				return IntStream.range(0, c).map(j -> {
					int n = (int) IntStream.range(0, r).filter(k -> b[k][j]).count();
					return Math.max(n, r - n);
				}).sum();
			}).max().getAsInt());
		}
	}
}
