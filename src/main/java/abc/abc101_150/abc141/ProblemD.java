package abc.abc101_150.abc141;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Queue<Integer> queue = new PriorityQueue<>((x, y) -> y.compareTo(x));
			IntStream.range(0, n).forEach(i -> queue.add(scanner.nextInt()));
			IntStream.range(0, m).forEach(i -> queue.add(queue.poll() / 2));
			System.out.println(queue.stream().mapToLong(i -> (long) i).sum());
		}
	}
}
