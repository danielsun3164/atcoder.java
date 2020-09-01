package abc.abc064;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			int max = IntStream.range(0, n).map(i -> a[i] = scanner.nextInt()).max().getAsInt();
			System.out.println(max - Arrays.stream(a).min().getAsInt());
		}
	}
}
