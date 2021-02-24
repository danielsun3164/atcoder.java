package abc.abc101_150.abc135;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n + 1).map(i -> scanner.nextInt()).toArray();
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			long answer = 0L;
			for (int i = n - 1; i >= 0; i--) {
				if (a[i + 1] >= b[i]) {
					answer += b[i];
					a[i + 1] -= b[i];
				} else {
					answer += a[i + 1];
					b[i] -= a[i + 1];
					a[i + 1] = 0;
					answer += (a[i] > b[i]) ? b[i] : a[i];
					a[i] = (a[i] > b[i]) ? a[i] - b[i] : 0;
				}
			}
			System.out.println(answer);
		}
	}
}
