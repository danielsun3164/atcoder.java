package abc.abc101_150.abc112;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	/** 最大値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), maxT = scanner.nextInt();
			int min = IntStream.range(0, n).map(i -> {
				int c = scanner.nextInt(), t = scanner.nextInt();
				return (t <= maxT) ? c : INF;
			}).min().getAsInt();
			System.out.println((INF == min) ? "TLE" : min);
		}
	}
}
