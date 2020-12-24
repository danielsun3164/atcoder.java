package abc.abc101_150.abc131;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			if (k > (n - 1) * (n - 2) / 2) {
				System.out.println(-1);
				return;
			}
			int m = (n - 1) * (n - 2) / 2 - k;
			System.out.println(m + n - 1);
			// 1から2...nの辺
			IntStream.rangeClosed(2, n).forEach(i -> System.out.println("1 " + i));
			// m本の2...nの間を結ぶ辺
			for (int i = 2; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					if (0 == m--) {
						return;
					}
					System.out.println(i + " " + j);
				}
			}
		}
	}
}
