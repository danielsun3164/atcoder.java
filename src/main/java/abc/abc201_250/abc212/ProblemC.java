package abc.abc201_250.abc212;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] a = new int[n];
			TreeSet<Integer> bSet = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextInt());
			IntStream.range(0, m).forEach(i -> bSet.add(scanner.nextInt()));
			System.out.println(IntStream.range(0, n).map(i -> {
				Integer ceiling = bSet.ceiling(a[i]), floor = bSet.floor(a[i]);
				return Math.min(Math.abs(((null == ceiling) ? Integer.MAX_VALUE : ceiling) - a[i]),
						Math.abs(((null == floor) ? Integer.MAX_VALUE : floor) - a[i]));
			}).min().getAsInt());
		}
	}
}
