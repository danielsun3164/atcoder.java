package abc.abc201_250.abc224;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int h = scanner.nextInt(), w = scanner.nextInt();
			long[][] a = new long[h][];
			IntStream.range(0, h)
					.forEach(i -> a[i] = IntStream.range(0, w).mapToLong(j -> scanner.nextLong()).toArray());
			for (int i1 = 0; i1 < h; i1++) {
				for (int i2 = i1 + 1; i2 < h; i2++) {
					for (int j1 = 0; j1 < w; j1++) {
						for (int j2 = j1 + 1; j2 < w; j2++) {
							if (a[i1][j1] + a[i2][j2] > a[i1][j2] + a[i2][j1]) {
								System.out.println("No");
								return;
							}
						}
					}
				}
			}
			System.out.println("Yes");
		}
	}
}
