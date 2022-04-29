package abc.abc151_200.abc165;

import java.util.Scanner;
import java.util.stream.LongStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int a = scanner.nextInt();
			long b = scanner.nextLong(), n = scanner.nextLong();
			if (Math.min(b, n) <= a) {
				System.out.println(LongStream.rangeClosed(1, Math.min(b, n)).map(i -> fn(a, b, i)).max().getAsLong());
			} else {
				System.out.println(LongStream.rangeClosed(Math.min(n, b) - a, Math.min(n, b)).map(i -> fn(a, b, i))
						.max().getAsLong());
			}
		}
	}

	/**
	 * floor(Ax/B)−A*floor(x/B) を計算する
	 * 
	 * @param a A
	 * @param b B
	 * @param x x
	 * @return floor(Ax/B)−A*floor(x/B) を計算する
	 */
	private static long fn(int a, long b, long x) {
		return a * x / b - a * (x / b);
	}
}
