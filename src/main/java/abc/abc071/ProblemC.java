package abc.abc071;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// それぞれの数字の数のマップ
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int ai = scanner.nextInt();
				map.put(ai, map.getOrDefault(ai, 0) + 1);
			});
			List<Entry<Integer, Integer>> resultList = map.entrySet().stream().filter(entry -> entry.getValue() > 1)
					.sorted((x, y) -> y.getKey().compareTo(x.getKey())).collect(Collectors.toList());
			long result = 0L;
			if (resultList.size() > 0) {
				Entry<Integer, Integer> firstEntry = resultList.get(0);
				if (firstEntry.getValue() >= 4) {
					result = ((long) firstEntry.getKey()) * firstEntry.getKey();
				} else {
					if (resultList.size() > 1) {
						Entry<Integer, Integer> secondEntry = resultList.get(1);
						result = ((long) firstEntry.getKey()) * secondEntry.getKey();
					}
				}
			}
			System.out.println(result);
		}
	}
}
