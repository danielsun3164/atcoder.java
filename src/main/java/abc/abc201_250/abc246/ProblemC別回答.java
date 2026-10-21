package abc.abc201_250.abc246;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc246/editorial/3707 の実装
 */
public class ProblemC別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt(), x = scanner.nextInt();
			int[] a = new int[n];
			long answer = IntStream.range(0, n).mapToLong(i -> a[i] = scanner.nextInt()).sum();
			long m = Math.min(k, Arrays.stream(a).mapToLong(ai -> ai / x).sum());
			answer -= m * x;
			k -= m;
			System.out.println(
					answer - ((k > 0) ? Arrays.stream(a).mapToLong(ai -> ai % x).sorted().skip(Math.max(0, n - k)).sum()
							: 0L));
		}
	}
}
