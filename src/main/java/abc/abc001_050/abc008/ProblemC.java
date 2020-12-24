package abc.abc001_050.abc008;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] c = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			System.out.println(Arrays.stream(c).map(ci -> getNumberOfYakusu(ci, c))
					.mapToDouble(s -> (0 == (s % 2)) ? (s + 2.0) / (2.0 * s + 2.0) : 0.5).sum());
		}
	}

	/**
	 * @param num
	 * @param c   数字の配列
	 * @return cの配列の中，numの約数の数（numを含まない）
	 */
	private static int getNumberOfYakusu(int num, int[] c) {
		return (int) (Arrays.stream(c).filter(ci -> (num % ci == 0)).count() - 1);
	}
}
