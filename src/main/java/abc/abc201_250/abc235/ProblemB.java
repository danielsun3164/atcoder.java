package abc.abc201_250.abc235;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] h = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int now = h[0];
			for (int i = 1; i < n; i++) {
				if (h[i] > now) {
					now = h[i];
				} else {
					break;
				}
			}
			System.out.println(now);
		}
	}
}
