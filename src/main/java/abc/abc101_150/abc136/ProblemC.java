package abc.abc101_150.abc136;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] h = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// max[i]=max(h[0],...,h[i])
			int[] max = new int[n];
			max[0] = h[0];
			IntStream.range(1, n).forEach(i -> max[i] = Math.max(max[i - 1], h[i]));
			boolean result = true;
			for (int i = 1; i < n; i++) {
				if (max[i] - h[i] > 1) {
					result = false;
					break;
				}
			}
			System.out.println(result ? "Yes" : "No");
		}
	}
}
