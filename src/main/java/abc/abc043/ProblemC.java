package abc.abc043;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			scanner.nextLine();
			int a[] = new int[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			scanner.nextLine();
			int average = (int) Math.round(Arrays.stream(a).average().getAsDouble());
			System.out.println(Arrays.stream(a).map(i -> (i - average) * (i - average)).sum());
		}
	}
}
