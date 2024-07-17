package abc.abc201_250.abc228;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt() - 1;
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt() - 1).toArray();
			boolean[] used = new boolean[n];
			Arrays.fill(used, false);
			dfs(a, used, x);
			System.out.println(IntStream.range(0, n).filter(i -> used[i]).count());
		}
	}

	/**
	 * すべての友達に秘密を知らせるため再帰的に処理する
	 *
	 * @param a    友達の一覧
	 * @param used 友達が秘密を知ったかどうかの一覧
	 * @param x    現在処理中の友達
	 */
	private static void dfs(int[] a, boolean[] used, int x) {
		used[x] = true;
		if (!used[a[x]]) {
			dfs(a, used, a[x]);
		}
	}
}
