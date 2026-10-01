package abc.abc201_250.abc243;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

	private static final int N = 3;
	private static final String[] NAMES = { "F", "M", "T" };

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int v = scanner.nextInt();
			int[] a = new int[N];
			v %= IntStream.range(0, N).map(i -> a[i] = scanner.nextInt()).sum();
			for (int i = 0; i < N; i++) {
				if (v < a[i]) {
					System.out.println(NAMES[i]);
					return;
				}
				v -= a[i];
			}
		}
	}
}
