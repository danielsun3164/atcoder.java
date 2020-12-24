package abc.abc101_150.abc116;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int s = scanner.nextInt();
			Set<Integer> set = new HashSet<>();
			int now = s, prev = -1, count = 1;
			while (!set.contains(now)) {
				set.add(now);
				prev = now;
				now = f(prev);
				count++;
			}
			System.out.println(count);
		}
	}

	/**
	 * f(n)を計算する
	 * 
	 * @param n
	 * @return f(n)
	 */
	private static int f(int n) {
		return (0 == (n & 1)) ? n / 2 : 3 * n + 1;
	}
}
