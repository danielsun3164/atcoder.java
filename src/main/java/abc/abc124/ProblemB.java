package abc.abc124;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int max = 0, count = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] >= max) {
					max = a[i];
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
