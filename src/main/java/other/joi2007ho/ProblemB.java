package other.joi2007ho;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] a = IntStream.range(0, k).map(i -> scanner.nextInt()).sorted().toArray();
			boolean hasBlank = (0 == a[0]);
			int count = 1, count2 = 1, max = 1;
			boolean usedBlank = false;
			for (int i = k - 2; i >= (hasBlank ? 1 : 0); i--) {
				if (a[i] + 1 == a[i + 1]) {
					max = Math.max(max, ++count);
					if (hasBlank) {
						max = Math.max(max, ++count2);
					}
				} else if (a[i] + 2 == a[i + 1]) {
					if (hasBlank) {
						max = Math.max(max, count2 = count + 2);
						usedBlank = true;
					}
					count = 1;
				} else {
					count = 1;
					count2 = 1;
				}
			}
			System.out.println((hasBlank && !usedBlank) ? max + 1 : max);
		}
	}
}
