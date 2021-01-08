package abc.abc101_150.abc119;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 円の通貨の文字列 */
	private static final String JPY = "JPY";
	/** BTCからJPYへ変換するレート */
	private static final BigDecimal RATE = BigDecimal.valueOf(380000L);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).mapToObj(i -> {
				String x = scanner.next(), u = scanner.next();
				return (JPY.equals(u)) ? new BigDecimal(x) : (new BigDecimal(x)).multiply(RATE);
			}).reduce(BigDecimal.ZERO, BigDecimal::add));
		}
	}
}
