package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class Problem055 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long p = scanner.nextLong(), q = scanner.nextLong();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong() % p).toArray();
			System.out.println(IntStream.range(0, n).mapToLong(i -> IntStream.range(i + 1, n).mapToLong(j -> IntStream
					.range(j + 1, n)
					.mapToLong(k -> IntStream.range(k + 1, n)
							.mapToLong(l -> IntStream.range(l + 1, n)
									.filter(m -> a[i] * a[j] % p * a[k] % p * a[l] % p * a[m] % p == q).count())
							.sum())
					.sum()).sum()).sum());
		}
	}
}
