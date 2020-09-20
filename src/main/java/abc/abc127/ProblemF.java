package abc.abc127;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 解説通りに作成したソースコード
 * 
 * https://atcoder.jp/contests/abc127/submissions/5869777 にも参考
 */
public class ProblemF {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			long b = 0L, answer = 0L;
			Queue<Integer> leftQueue = new PriorityQueue<>(Comparator.reverseOrder());
			Queue<Integer> rightQueue = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				int command = scanner.nextInt();
				if (1 == command) {
					int a = scanner.nextInt();
					b += scanner.nextInt();
					if (leftQueue.isEmpty()) {
						leftQueue.add(a);
					} else if (a < leftQueue.peek()) {
						leftQueue.add(a);
						answer += leftQueue.peek() - a;
					} else {
						rightQueue.add(a);
						answer += a - leftQueue.peek();
					}
					if (leftQueue.size() - rightQueue.size() > 1) {
						rightQueue.add(leftQueue.poll());
						answer += (rightQueue.peek() - leftQueue.peek()) * (rightQueue.size() - leftQueue.size());
					} else if (rightQueue.size() > leftQueue.size()) {
						answer += (rightQueue.peek() - leftQueue.peek()) * (leftQueue.size() - rightQueue.size());
						leftQueue.add(rightQueue.poll());
					}
				} else {
					System.out.println(leftQueue.peek() + " " + (answer + b));
				}
			}
		}
	}
}
