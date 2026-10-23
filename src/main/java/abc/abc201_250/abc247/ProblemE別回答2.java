package abc.abc201_250.abc247;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc247/editorial/3777 の実装
 */
public class ProblemE別回答2 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt(), y = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int posX = -1, posY = -1, b = -1;
			long answer = 0L;
			for (int i = 0; i < n; i++) {
				if (x == a[i]) {
					posX = i;
				}
				if (y == a[i]) {
					posY = i;
				}
				if ((a[i] < y) || (a[i] > x)) {
					b = i;
				}
				answer += Math.max(0L, Math.min(posX, posY) - b);
			}
			System.out.println(answer);
		}
	}
}
