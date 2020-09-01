package abc.abc170;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int x = scanner.nextInt(), n = scanner.nextInt();
			Set<Integer> set = IntStream.range(0, n).map(i -> scanner.nextInt()).boxed().collect(Collectors.toSet());
			int diff = 0;
			while (true) {
				if (!set.contains(x - diff)) {
					System.out.println(x - diff);
					break;
				}
				if (!set.contains(x + diff)) {
					System.out.println(x + diff);
					break;
				}
				diff++;
			}
		}
	}
}
