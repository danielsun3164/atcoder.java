package abc.abc101_150.abc130;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), x = scanner.nextInt();
			int[] l = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int sum = 0, i = 0;
			for (i = 0; i < n; i++) {
				sum += l[i];
				if (sum > x) {
					break;
				}
			}
			System.out.println(i + 1);
		}
	}
}
