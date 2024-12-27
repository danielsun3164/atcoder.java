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
		return switch ((int) remainder) {
		case 0 -> input;
		case 1 -> 1L;
		case 2 -> input + 1;
		default -> 0L;
		};
	}
}
