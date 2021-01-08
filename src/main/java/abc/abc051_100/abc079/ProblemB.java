package abc.abc051_100.abc079;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long[] l = new long[n + 1];
			l[0] = 2;
			l[1] = 1;
			IntStream.rangeClosed(2, n).forEach(i -> l[i] = l[i - 1] + l[i - 2]);
			System.out.println(l[n]);
		}
	}
}
