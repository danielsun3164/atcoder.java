package abc.abc180;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			SortedSet<Long> set = new TreeSet<>();
			for (long i = 1; i * i <= n; i++) {
				if (0 == (n % i)) {
					set.add(i);
					set.add(n / i);
				}
			}
			set.stream().forEach(System.out::println);
		}
	}
}
