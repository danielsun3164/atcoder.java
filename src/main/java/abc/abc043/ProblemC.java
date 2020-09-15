package abc.abc043;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int a[] = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int average = (int) Math.round(Arrays.stream(a).average().getAsDouble());
			System.out.println(Arrays.stream(a).map(i -> (i - average) * (i - average)).sum());
		}
	}
}
