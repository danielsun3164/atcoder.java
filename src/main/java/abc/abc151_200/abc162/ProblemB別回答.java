package abc.abc151_200.abc162;

import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 *
 * O(1)の回答
 */
public class ProblemB別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			System.out.println(sum(n) - sum(n / 3) * 3 - sum(n / 5) * 5 + sum(n / 15) * 15);
		}
	}

	/**
	 * 1からnまでの合計値を計算する
	 *
	 * @param n
	 * @return 1からnまでの合計値
	 */
	private static long sum(int n) {
		return n * (long) (n + 1) / 2;
	}
}
