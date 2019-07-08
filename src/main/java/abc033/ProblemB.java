package abc033;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			String[] s = new String[n];
			int[] p = new int[n];
			IntStream.range(0, n).forEach(i -> {
				s[i] = scanner.next();
				p[i] = scanner.nextInt();
			});
			int max = Arrays.stream(p).max().getAsInt();
			int sum = Arrays.stream(p).sum();
			if (max > sum / 2) {
				int maxIndex = IntStream.range(0, n).filter(i -> p[i] == max).findFirst().getAsInt();
				System.out.println(s[maxIndex]);
			} else {
				System.out.println("atcoder");
			}
		}
	}
}
