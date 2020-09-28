package other.joi2006yo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), k = scanner.nextInt(), m = scanner.nextInt(), r = scanner.nextInt();
			BigDecimal fraction = BigDecimal.ONE.divide(BigDecimal.valueOf(n), r + 1, RoundingMode.HALF_DOWN);
			if (0 == m) {
				System.out.println(fraction.setScale(r, RoundingMode.DOWN));
			} else {
				BigDecimal result = fraction.add(fraction
						.multiply(IntStream.range(1, n).mapToObj(i -> BigDecimal.valueOf(i)).reduce(BigDecimal.ZERO,
								(sum, next) -> sum.add(BigDecimal.ONE.divide(next, r + 1, RoundingMode.HALF_DOWN)))));
				System.out.println(result.setScale(r, RoundingMode.DOWN));
			}
		}
	}
}
