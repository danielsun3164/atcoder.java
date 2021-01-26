package abc.abc151_200.abc189;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int answer = 0;
			for (int i = 0; i < n; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = i; j < n; j++) {
					min = Math.min(min, a[j]);
					answer = Math.max(answer, min * (j - i + 1));
				}
			}
			System.out.println(answer);
		}
	}
}
