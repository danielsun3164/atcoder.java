package other.apg4b;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemEX23 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				int a = scanner.nextInt();
				map.put(a, map.getOrDefault(a, 0) + 1);
			});
			Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
					(x, y) -> y.getValue().compareTo(x.getValue()));
			map.entrySet().forEach(queue::add);
			Entry<Integer, Integer> entry = queue.poll();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
