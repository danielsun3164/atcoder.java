package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://github.com/E869120/kyopro_educational_90/blob/main/sol/080b.cpp をもとに作成
 */
public class Problem080別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), d = scanner.nextInt();
			long[] a = IntStream.range(0, n).mapToLong(i -> scanner.nextLong()).toArray();
			long[] bits = new long[1 << n];
			Arrays.fill(bits, 0L);
			IntStream.range(0, n)
					.forEach(i -> IntStream.range(0, 1 << i).forEach(j -> bits[j + (1 << i)] = (bits[j] | a[i])));
			System.out.println(IntStream.range(0, 1 << n).mapToLong(i -> {
				int freeDigits = d - Long.bitCount(bits[i]);
				return (0 == (Integer.bitCount(i) & 1)) ? (1L << freeDigits) : -(1L << freeDigits);
			}).sum());
		}
	}
}
