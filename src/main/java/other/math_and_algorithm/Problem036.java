package other.math_and_algorithm;

import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class Problem036 {

	/** 12 */
	private static final int N = 12;
	/** 60 */
	private static final int M = 60;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt(), b = scanner.nextInt(), h = scanner.nextInt(), m = scanner.nextInt();
			double hDegree = 2 * Math.PI * (h * M + m) / N / M, mDegree = 2 * Math.PI * m / M;
			double ax = a * Math.sin(hDegree), ay = a * Math.cos(hDegree), bx = b * Math.sin(mDegree),
					by = b * Math.cos(mDegree);
			System.out.println(Math.hypot(ax - bx, ay - by));
		}
	}
}
