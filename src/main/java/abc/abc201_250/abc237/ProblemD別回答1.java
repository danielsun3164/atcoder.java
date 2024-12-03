package abc.abc201_250.abc237;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc237/editorial/3319 の実装
 */
public class ProblemD別回答1 {

	/** 左を表す文字 */
	private static final char LEFT = 'L';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			Deque<Integer> que = new ArrayDeque<>();
			que.addFirst(n);
			IntStream.iterate(n - 1, i -> i >= 0, i -> i - 1).forEach(i -> {
				if (LEFT == s[i]) {
					que.addLast(i);
				} else {
					que.addFirst(i);
				}
			});
			System.out.println(que.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
