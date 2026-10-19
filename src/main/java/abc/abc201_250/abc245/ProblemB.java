package abc.abc201_250.abc245;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemB {

	/** 最大値 */
	private static final int N = 2000;

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Set<Integer> aSet = IntStream.range(0, n).map(_ -> scanner.nextInt()).boxed().collect(Collectors.toSet());
			for (int i = 0; i <= N + 1; i++) {
				if (!aSet.contains(i)) {
					System.out.println(i);
					return;
				}
			}
		}
	}
}
