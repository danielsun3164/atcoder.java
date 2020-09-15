package abc.abc093;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			IntStream.range(0, q).mapToLong(i -> getResult(scanner.nextInt(), scanner.nextInt()))
					.forEach(System.out::println);
		}
	}

	/**
	 * 順位が高橋より低い最大の人数を計算する （解説通りに実装）
	 * 
	 * @param a 高橋の1回目の順位
	 * @param b 高橋の2回目の順位
	 * @return 順位が高橋より低い最大の人数
	 */
	private static long getResult(long a, long b) {
		if (1 >= Math.abs(a - b)) {
			return 2 * Math.min(a, b) - 2;
		}
		long c = (long) Math.sqrt(a * b);
		if (c * c == a * b) {
			c--;
		}
		if (c * (c + 1) >= a * b) {
			return 2 * c - 2;
		} else {
			return 2 * c - 1;
		}
	}
}
