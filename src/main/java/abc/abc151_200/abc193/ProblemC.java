package abc.abc151_200.abc193;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			// 2以上の整数a,bを用いて a^b と表せる数字のセット
			Set<Long> okSet = new HashSet<>();
			for (long i = 2L; i * i <= n; i++) {
				for (long j = i * i; j <= n; j *= i) {
					okSet.add(j);
				}
			}
			System.out.println(n - okSet.size());
		}
	}
}
