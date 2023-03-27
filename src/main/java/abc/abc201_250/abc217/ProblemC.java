package abc.abc201_250.abc217;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] q = new int[n];
			IntStream.range(0, n).forEach(i -> {
				int p = scanner.nextInt() - 1;
				q[p] = i + 1;
			});
			System.out.println(Arrays.stream(q).mapToObj(qi -> String.valueOf(qi)).collect(Collectors.joining(" ")));
		}
	}
}
