package abc.abc151_200.abc176;

import java.math.BigInteger;
import java.util.Scanner;

public class ProblemB別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			BigInteger n = new BigInteger(scanner.next());
			System.out.println(BigInteger.ZERO.equals(n.mod(BigInteger.valueOf(9))) ? "Yes" : "No");
		}
	}
}
