package abc.abc115;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), k = scanner.nextInt();
			int[] h = IntStream.range(0, n).map(i -> scanner.nextInt()).sorted().toArray();
			System.out.println(IntStream.rangeClosed(0, n - k).map(i -> h[i + k - 1] - h[i]).min().getAsInt());
		}
	}
}
