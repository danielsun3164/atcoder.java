package abc.abc201_250.abc234;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class ProblemE {

	/** 10 */
	private static final int TEN = 10;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String x = scanner.next();
			if (x.length() <= 2) {
				System.out.println(x);
				return;
			}
			NavigableSet<Long> set = arithmeticNumberSet(x.length());
			System.out.println(set.ceiling(Long.parseLong(x)));
		}
	}

	/**
	 * 指定された長さの等差数の一覧を作成する
	 *
	 * @param length
	 * @return 指定された長さの等差数の一覧
	 */
	private static NavigableSet<Long> arithmeticNumberSet(int length) {
		NavigableSet<Long> set = new TreeSet<>();
		int maxD = TEN / (length - 1);
		for (int i = 0; i <= maxD; i++) {
			for (int j = 0; j < TEN; j++) {
				if (j + (length - 1) * i >= TEN) {
					break;
				}
				StringBuilder sb = new StringBuilder();
				for (int k = j;; k += i) {
					sb.append(k);
					if (sb.length() >= length) {
						break;
					}
				}
				set.add(Long.parseLong(sb.toString()));
				set.add(Long.parseLong(sb.reverse().toString()));
			}
		}
		return set;
	}
}
