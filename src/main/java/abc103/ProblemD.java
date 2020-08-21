package abc103;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説どおりに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc103/submissions/15700130 にも参考
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), m = scanner.nextInt();
			Pair[] pairs = new Pair[m];
			IntStream.range(0, m).forEach(i -> pairs[i] = new Pair(scanner.nextInt() - 1, scanner.nextInt() - 1));
			Arrays.sort(pairs);
			int count = 1, current = pairs[0].b;
			for (int i = 1; i < m; i++) {
				if (pairs[i].a >= current) {
					current = pairs[i].b;
					count++;
				}
			}
			System.out.println(count);
		}
	}

	/**
	 * aとbを格納するクラス
	 */
	private static class Pair implements Comparable<Pair> {
		int a;
		int b;

		Pair(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair pair) {
			return Integer.compare(this.b, pair.b);
		}
	}
}
