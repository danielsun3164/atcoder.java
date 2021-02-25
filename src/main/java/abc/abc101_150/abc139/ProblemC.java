package abc.abc101_150.abc139;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] h = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] d = new int[n];
			d[n - 1] = 0;
			IntStream.range(0, n - 1).map(i -> n - 2 - i).forEach(i -> d[i] = (h[i] >= h[i + 1]) ? d[i + 1] + 1 : 0);
			System.out.println(Arrays.stream(d).max().getAsInt());
		}
	}
}
