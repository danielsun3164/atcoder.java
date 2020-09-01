package abc.abc003;

import java.math.BigInteger;
import java.util.Scanner;

public class ProblemD {

	private static BigInteger BIG = BigInteger.valueOf(1000000007L);

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int d = scanner.nextInt();
			int l = scanner.nextInt();
			BigInteger xy = BigInteger.valueOf(r - x + 1).multiply(BigInteger.valueOf(c - y + 1));
			BigInteger multiply = xy.multiply(getResult(x, y, d, l));
			System.out.println(multiply.remainder(BIG));
		}
	}

	private static BigInteger getResult(int x, int y, int d, int l) {
		BigInteger result = p(x, y, d, l);
		// 1辺がくっついていないパターン
		result = result.subtract(BigInteger.valueOf(2).multiply(p(x - 1, y, d, l)))
				.subtract(BigInteger.valueOf(2).multiply(p(x, y - 1, d, l)));
		// 2辺がくっついていないパターン
		result = result.add(BigInteger.valueOf(4).multiply(p(x - 1, y - 1, d, l)));
		result = result.add(p(x - 2, y, d, l)).add(p(x, y - 2, d, l));
		// 3辺がくっついていないパターン
		result = result.subtract(BigInteger.valueOf(2).multiply(p(x - 2, y - 1, d, l)))
				.subtract(BigInteger.valueOf(2).multiply(p(x - 1, y - 2, d, l)));
		// 4辺がくっついていないパターン
		result = result.add(p(x - 2, y - 2, d, l));
		return result;
	}

	private static BigInteger p(int x, int y, int d, int l) {
		if ((x > 0) && (y > 0) && (x * y >= (d + l))) {
			return C(x * y, d).multiply(C(x * y - d, l));
		}
		return BigInteger.ZERO;
	}

	private static BigInteger C(int n, int m) {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= Math.min(n - m, m); i++) {
			result = result.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
		}
		return result;
	}
}
