package other.typical90;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/080a.cpp をもとに作成
 */
public class Problem080 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			System.out.println(IntStream.range(0, 1 << n).mapToLong(i -> {
				long bit = IntStream.range(0, n).filter(j -> (i & (1 << j)) > 0).mapToLong(j -> a[j]).reduce(0L,
						(s, ai) -> s | ai);
				long conditions = IntStream.range(0, n).filter(j -> (i & (1 << j)) > 0).count();
				int freeDigits = d - Long.bitCount(bit);
				return (0 == (1L & conditions)) ? (1L << freeDigits) : -(1L << freeDigits);
			}).sum());
		}
	}
}
