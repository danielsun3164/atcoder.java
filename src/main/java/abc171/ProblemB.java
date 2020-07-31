package abc171;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] p = new int[n];
			IntStream.range(0, n).forEach(i -> p[i] = scanner.nextInt());
			System.out.println(Arrays.stream(p).sorted().limit(k).sum());
		}
	}
}
