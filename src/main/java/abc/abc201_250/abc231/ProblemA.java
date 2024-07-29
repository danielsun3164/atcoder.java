package abc.abc201_250.abc231;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProblemA {

	/** 水圧を計算するためのしきい値 */
	private static final String N = "100";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigDecimal d = new BigDecimal(scanner.next());
			System.out.println(d.divide(new BigDecimal(N)).toString());
		}
	}
}
