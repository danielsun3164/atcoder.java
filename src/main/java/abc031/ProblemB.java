package abc031;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int l = scanner.nextInt();
			int h = scanner.nextInt();
			int n = scanner.nextInt();
			IntStream.range(0, n).map(i -> {
				int a = scanner.nextInt();
				if (a < l) {
					return l - a;
				} else if ((a >= l) && (a <= h)) {
					return 0;
				} else {
					return -1;
				}
			}).forEach(System.out::println);
		}
	}
}
