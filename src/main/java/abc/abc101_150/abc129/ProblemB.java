package abc.abc101_150.abc129;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] w = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int sum = Arrays.stream(w).sum();
			// sum1[i]=w[0]+...+w[i]、sum2[i]=w[i+1]+...+w[n-1]
			int[] sum1 = new int[n], sum2 = new int[n];
			sum1[0] = w[0];
			sum2[0] = sum - w[0];
			System.out.println(IntStream.range(1, n - 1).map(i -> {
				sum1[i] = sum1[i - 1] + w[i];
				sum2[i] = sum2[i - 1] - w[i];
				return Math.abs(sum1[i] - sum2[i]);
			}).min().getAsInt());
		}
	}
}
