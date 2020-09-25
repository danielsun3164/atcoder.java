package other.joi2006ho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemA {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(
					i -> IntStream.range(0, m).forEach(j -> map.put(j, map.getOrDefault(j, 0) + scanner.nextInt())));
			System.out.println(map.entrySet().stream().sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
					.map(entry -> String.valueOf(entry.getKey() + 1)).collect(Collectors.joining(" ")));
		}
	}
}
