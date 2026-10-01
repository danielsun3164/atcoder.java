package abc.abc201_250.abc243;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ProblemD {

	private static final char UP = 'U';
	private static final char LEFT = 'L';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			BigInteger x = new BigInteger(scanner.next()), two = BigInteger.valueOf(2L);
			char[] s = scanner.next().toCharArray();
			Deque<Character> que = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				if (UP == s[i]) {
					if (que.isEmpty()) {
						x = x.divide(two);
					} else {
						que.pollLast();
					}
				} else {
					que.addLast(s[i]);
				}
			}
			while (!que.isEmpty()) {
				char c = que.poll();
				if (LEFT == c) {
					x = x.multiply(two);
				} else {
					x = x.multiply(two).add(BigInteger.ONE);
				}
			}
			System.out.println(x);
		}
	}
}
