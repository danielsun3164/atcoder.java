package abc.abc201_250.abc226;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String x = scanner.next();
			System.out.println((new BigDecimal(x)).setScale(0, RoundingMode.HALF_UP).intValue());
		}
	}
}
