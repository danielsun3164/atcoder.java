package abc.abc201_250.abc213;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			@SuppressWarnings("unused")
			int h = scanner.nextInt(), w = scanner.nextInt(), n = scanner.nextInt();
			int[] a = new int[n], b = new int[n];
			Set<Integer> setA = new TreeSet<>(), setB = new TreeSet<>();
			IntStream.range(0, n).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
				setA.add(a[i]);
				setB.add(b[i]);
			});
			Map<Integer, Integer> mapA = new HashMap<>(), mapB = new HashMap<>();
			int count = 1;
			for (int ai : setA) {
				mapA.put(ai, count++);
			}
			count = 1;
			for (int bi : setB) {
				mapB.put(bi, count++);
			}
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			IntStream.range(0, n).forEach(
					i -> sb.append(mapA.get(a[i])).append(" ").append(mapB.get(b[i])).append(System.lineSeparator()));
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
