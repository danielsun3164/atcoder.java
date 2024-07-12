package abc.abc201_250.abc227;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(IntStream.range(0, n).map(i -> scanner.nextInt()).filter(s -> !check(s)).count());
		}
	}

	/**
	 * 面積sが4ab+3a+3bの式で計算できるかを判定する
	 *
	 * @param s 面積
	 * @return 面積sが4ab+3a+3bの式で計算できるか
	 */
	private static boolean check(int s) {
		for (int a = 1; s - 7 * a >= 3; a++) {
			int c = 4 * a + 3, t = s - 3 * a;
			if ((t > 0) && (0 == t % c)) {
				return true;
			}
		}
		return false;
	}
}
