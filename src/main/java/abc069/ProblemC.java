package abc069;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// count[0]は1の倍数の数、count[1]は2の倍数の数、count[2]は4の倍数の数
			int[] count = new int[3];
			IntStream.range(0, n).forEach(i -> count[getMultiple(scanner.nextInt())]++);
			System.out.println((count[2] >= (count[0] - ((count[1] > 0) ? 0 : 1))) ? "Yes" : "No");
		}
	}

	/**
	 * @param n 入力数字
	 * @return 0：nは1の倍数、1：nが2の倍数、2：nが4の倍数
	 */
	private static int getMultiple(int n) {
		int result = 0;
		while (0 == (n & 1)) {
			result++;
			n >>= 1;
			if (result >= 2) {
				break;
			}
		}
		return result;
	}
}
