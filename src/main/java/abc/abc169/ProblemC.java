package abc.abc169;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigDecimal a = BigDecimal.valueOf(scanner.nextLong());
			BigDecimal b = new BigDecimal(scanner.next());
			System.out.println(a.multiply(b).setScale(0, RoundingMode.FLOOR));
		}
	}
}
