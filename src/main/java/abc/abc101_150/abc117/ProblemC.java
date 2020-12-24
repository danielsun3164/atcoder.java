package abc.abc101_150.abc117;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			int[] x = IntStream.range(0, m).map(i -> scanner.nextInt()).sorted().toArray();
			Queue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			IntStream.range(1, m).forEach(i -> queue.add(x[i] - x[i - 1]));
			int sum = Arrays.stream(x).max().getAsInt() - Arrays.stream(x).min().getAsInt();
			System.out.println(sum - IntStream.range(1, Math.min(n, m)).map(i -> queue.poll()).sum());
		}
	}
}
