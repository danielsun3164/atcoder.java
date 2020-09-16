package abc.abc121;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemB {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt(), c = scanner.nextInt();
			int b[] = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			System.out.println(IntStream.range(0, n).filter(i -> {
				int sum = IntStream.range(0, m).map(j -> scanner.nextInt() * b[j]).sum();
				return (sum + c) > 0;
			}).count());
		}
	}
}
