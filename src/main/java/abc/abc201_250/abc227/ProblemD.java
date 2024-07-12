package abc.abc201_250.abc227;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc227/editorial/2911 の実装
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long ok = 0, ng = Arrays.stream(a).max().getAsLong() * n / k + 1;
			while (ng > ok + 1) {
				long med = (ok + ng) / 2;
				if (Arrays.stream(a).map(ai -> Math.min(ai, med)).sum() >= med * k) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}
}
