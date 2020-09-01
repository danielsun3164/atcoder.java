package abc.abc085;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int h = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			int maxA = Arrays.stream(a).max().getAsInt();
			int[] filteredB = Arrays.stream(b).filter(i -> i > maxA).toArray();
			long filterdBSum = Arrays.stream(filteredB).mapToLong(i -> (long) i).sum();
			if (h > filterdBSum) {
				System.out.println(((h - filterdBSum) + maxA - 1) / maxA + filteredB.length);
			} else {
				Arrays.sort(filteredB);
				int i = filteredB.length;
				while (h > 0) {
					h -= filteredB[--i];
				}
				System.out.println(filteredB.length - i);
			}
		}
	}
}
