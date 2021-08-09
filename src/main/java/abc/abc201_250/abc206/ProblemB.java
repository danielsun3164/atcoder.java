package abc.abc201_250.abc206;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			long n = scanner.nextLong();
			long ng = 0L, ok = 1_000_000_000L;
			while (ok > (ng + 1L)) {
				long med = (ok + ng) >> 1;
				if (((med * (med + 1)) / 2) >= n) {
					ok = med;
				} else {
					ng = med;
				}
			}
			System.out.println(ok);
		}
	}
}
