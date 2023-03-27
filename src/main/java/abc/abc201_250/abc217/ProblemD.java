package abc.abc201_250.abc217;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int l = scanner.nextInt(), q = scanner.nextInt();
			NavigableSet<Integer> set = new TreeSet<>();
			set.add(0);
			set.add(l);
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int c = scanner.nextInt(), x = scanner.nextInt();
				if (1 == c) {
					set.add(x);
				} else {
					sb.append(set.higher(x) - set.lower(x)).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
