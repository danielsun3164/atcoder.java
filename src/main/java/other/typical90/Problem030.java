package other.typical90;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem030 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] counts = new int[n + 1];
			Arrays.fill(counts, 0);
			IntStream.rangeClosed(2, n).forEach(i -> {
				if (0 == counts[i]) {
					for (int j = i; j <= n; j += i) {
						counts[j]++;
					}
				}
			});
			System.out.println(Arrays.stream(counts).filter(count -> count >= k).count());
		}
	}
}
