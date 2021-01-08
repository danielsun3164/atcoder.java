package abc.abc001_050.abc036;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Set<Integer> set = new HashSet<>();
			int[] a = new int[n];
			IntStream.range(0, n).forEach(i -> set.add(a[i] = scanner.nextInt()));
			Integer[] integers = set.toArray(new Integer[set.size()]);
			Arrays.sort(integers);
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, set.size()).forEach(i -> map.put(integers[i], i));
			Arrays.stream(a).forEach(ai -> System.out.println(map.get(ai)));
		}
	}
}
