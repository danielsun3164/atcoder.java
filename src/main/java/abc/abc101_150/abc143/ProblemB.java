package abc.abc101_150.abc143;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// sum[i]=d[0]+...+d[i]
			int[] d = new int[n], sum = new int[n];
			IntStream.range(0, n).forEach(i -> {
				d[i] = scanner.nextInt();
				sum[i] = (0 == i) ? d[i] : sum[i - 1] + d[i];
			});
			System.out.println(IntStream.range(1, n).map(i -> sum[i - 1] * d[i]).sum());
		}
	}
}
