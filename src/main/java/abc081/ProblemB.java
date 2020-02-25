package abc081;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> devide2Count(scanner.nextInt())).min().getAsInt());
		}
	}

	/**
	 * @param number
	 * @return numberが何回2で割れるか
	 */
	private static int devide2Count(int number) {
		int result = 0;
		while ((number & 1) == 0) {
			number >>= 1;
			result++;
		}
		return result;
	}
}
