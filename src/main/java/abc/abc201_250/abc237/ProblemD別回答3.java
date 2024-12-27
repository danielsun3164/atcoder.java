package abc.abc201_250.abc237;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://atcoder.jp/contests/abc237/editorial/3323 の実装
 */
public class ProblemD別回答3 {

	/** 左を表す文字 */
	private static final char LEFT = 'L';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			Deque<Integer> l = new ArrayDeque<>(), r = new ArrayDeque<>();
			IntStream.range(0, n).forEach(i -> ((LEFT == s[i]) ? r : l).addLast(i));
			StringBuilder sb = new StringBuilder();
			while (!l.isEmpty()) {
				sb.append(l.pollFirst()).append(" ");
			}
			sb.append(n);
			while (!r.isEmpty()) {
				sb.append(" ").append(r.pollLast());
			}
			System.out.println(sb.toString());
		}
	}
}
