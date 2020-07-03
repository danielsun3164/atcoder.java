package past201912;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			IntStream.range(1, n).forEach(i -> {
				if (a[i] == a[i - 1]) {
					System.out.println("stay");
				} else {
					System.out.println(((a[i] > a[i - 1]) ? "up" : "down") + " " + Math.abs(a[i] - a[i - 1]));
				}
			});
		}
	}
}
