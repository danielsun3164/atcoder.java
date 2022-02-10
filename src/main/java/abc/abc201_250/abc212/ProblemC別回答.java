package abc.abc201_250.abc212;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemC別回答 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			int[] b = IntStream.range(0, m).map(i -> scanner.nextInt()).sorted().toArray();
			int answer = Integer.MAX_VALUE;
			int x = 0, y = 0;
			while ((x < n) && (y < m)) {
				answer = Math.min(answer, Math.abs(a[x] - b[y]));
				if (a[x] < b[y]) {
					x++;
				} else {
					y++;
				}
			}
			System.out.println(answer);
		}
	}
}
