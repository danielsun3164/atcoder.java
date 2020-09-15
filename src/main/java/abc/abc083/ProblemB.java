package abc.abc083;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
			System.out.println(IntStream.rangeClosed(1, n).filter(i -> {
				int digitSum = digitSum(i);
				return (digitSum >= a) && (digitSum <= b);
			}).sum());
		}
	}

	/**
	 * @param number
	 * @return numberの10進数の各桁の合計
	 */
	private static int digitSum(int number) {
		int result = 0;
		while (number > 0) {
			result += number % 10;
			number /= 10;
		}
		return result;
	}
}
