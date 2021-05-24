package abc.abc201_250.abc202;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Integer, Integer> aMap = new HashMap<>(), cMap = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				aMap.put(a, aMap.getOrDefault(a, 0) + 1);
			});
			int[] b = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			IntStream.range(0, n).forEach(i -> {
				int c = scanner.nextInt();
				cMap.put(c, cMap.getOrDefault(c, 0) + 1);
			});
			System.out.println(IntStream.range(0, n)
					.mapToLong(i -> aMap.getOrDefault(b[i], 0) * (long) cMap.getOrDefault(i + 1, 0)).sum());
		}
	}
}
