package abc.abc201_250.abc237;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://atcoder.jp/contests/abc237/editorial/3345 の実装
 */
public class ProblemD別回答2 {

	/** 左を表す文字 */
	private static final char LEFT = 'L';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			char[] s = scanner.next().toCharArray();
			LinkedList<Integer> list = new LinkedList<>();
			list.add(0);
			ListIterator<Integer> iterator = list.listIterator();
			iterator.next();
			for (int i = 1; i <= n; i++) {
				if (LEFT == s[i - 1]) {
					iterator.previous();
				}
				iterator.add(i);
			}
			System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
