package abc.abc151_200.abc161;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに作成したソースコード
 */
public class ProblemD別回答 {

	/** 1桁の数字の上限値 */
	private static final int N = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int k = scanner.nextInt();
			Queue<Long> que = new ArrayDeque<>();
			IntStream.range(1, N).forEach(i -> que.add((long) i));
			while (true) {
				long now = que.poll();
				k--;
				if (0 == k) {
					System.out.println(now);
					return;
				}
				int d = (int) (now % N);
				IntStream.rangeClosed(Math.max(0, d - 1), Math.min(9, d + 1)).forEach(i -> que.add(now * N + i));
			}
		}
	}
}
