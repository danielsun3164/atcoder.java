package abc.abc101_150.abc121;

import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			System.out.println(result(a - 1) ^ result(b));
		}
	}

	/**
	 * @param input
	 * @return 0〜input の配列をXORした結果
	 */
	private static long result(long input) {
		long remainder = input % 4L;
		switch ((int) remainder) {
		case 0:
			return input;
		case 1:
			return 1L;
		case 2:
			return input + 1;
		case 3:
		default:
			return 0L;
		}
	}
}
