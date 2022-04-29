package abc.abc151_200.abc165;

import java.math.BigInteger;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger x = new BigInteger(scanner.next());
			int count = 0;
			BigInteger denominator = BigInteger.valueOf(100L);
			BigInteger balance = denominator;
			BigInteger molecule = BigInteger.valueOf(101L);
			while (balance.compareTo(x) < 0) {
				balance = balance.multiply(molecule).divide(denominator);
				count++;
			}
			System.out.println(count);
		}
	}
}
