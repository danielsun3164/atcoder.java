package abc.abc051_100.abc068;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			BitSet routeTo1 = new BitSet(n), routeToN = new BitSet(n);
			IntStream.range(0, m).forEach(i -> {
				int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
				if (0 == Math.min(a, b)) {
					routeTo1.set(Math.max(a, b), true);
				}
				if (n - 1 == Math.max(a, b)) {
					routeToN.set(Math.min(a, b), true);
				}
			});
			int count = (int) IntStream.range(1, n - 1).filter(i -> routeTo1.get(i) && routeToN.get(i)).count();
			System.out.println((count > 0) ? "POSSIBLE" : "IMPOSSIBLE");
		}
	}
}
