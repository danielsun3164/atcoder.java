package other.math_and_algorithm;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Problem013 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			Set<Long> set = new TreeSet<>();
			for (long i = 1; i * i <= n; i++) {
				if (0 == n % i) {
					set.add(i);
					set.add(n / i);
				}
			}
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			set.forEach(si -> sb.append(si).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
