package abc.abc101_150.abc117;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] l = new int[n];
			int sum = IntStream.range(0, n).map(i -> l[i] = scanner.nextInt()).sum();
			int max = Arrays.stream(l).max().getAsInt();
			System.out.println(((sum - max) > max) ? "Yes" : "No");
		}
	}
}
