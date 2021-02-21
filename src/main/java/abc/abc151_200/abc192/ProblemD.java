package abc.abc151_200.abc192;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			char[] x = scanner.next().toCharArray();
			BigInteger m = BigInteger.valueOf(scanner.nextLong());
			int[] xs = new int[x.length];
			IntStream.range(0, x.length).forEach(i -> xs[x.length - 1 - i] = x[i] - '0');
			int max = Arrays.stream(xs).max().getAsInt();
			if (1 == x.length) {
				// 解説どおりの条件を追加
				System.out.println((m.longValue() >= max) ? 1 : 0);
			} else {
				long left = max, right = m.longValue() + 1L;
				while (right > left + 1L) {
					long med = (left + right) / 2;
					if (getValue(xs, med).compareTo(m) <= 0) {
						left = med;
					} else {
						right = med;
					}
				}
				System.out.println(left - max);
			}
		}
	}

	private static BigInteger getValue(int[] xs, long radix) {
		BigInteger result = BigInteger.ZERO, r = BigInteger.ONE;
		for (int xsi : xs) {
			result = result.add(r.multiply(BigInteger.valueOf(xsi)));
			r = r.multiply(BigInteger.valueOf(radix));
		}
		return result;
	}
}
