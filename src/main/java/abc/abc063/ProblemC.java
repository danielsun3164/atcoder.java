package abc.abc063;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] s = new int[n];
			Queue<Integer> queue = new PriorityQueue<>();
			int sum = IntStream.range(0, n).map(i -> {
				s[i] = scanner.nextInt();
				if (0 != (s[i] % 10)) {
					queue.add(s[i]);
				}
				return s[i];
			}).sum();
			if (0 == (sum % 10)) {
				if (0 == queue.size()) {
					System.out.println(0);
				} else {
					System.out.println(sum - queue.poll());
				}
			} else {
				System.out.println(sum);
			}
		}
	}
}
