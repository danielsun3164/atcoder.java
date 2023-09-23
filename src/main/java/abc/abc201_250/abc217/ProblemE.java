package abc.abc201_250.abc217;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 解説通りに実装したソースコード
 */
public class ProblemE {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			Queue<Integer> que1 = new ArrayDeque<>(), que2 = new PriorityQueue<>();
			// TLE対応のため、出力はStringBuilderを使用
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int c = scanner.nextInt();
				if (1 == c) {
					int x = scanner.nextInt();
					que1.add(x);
				} else if (2 == c) {
					sb.append(que2.isEmpty() ? que1.poll() : que2.poll()).append(System.lineSeparator());
				} else {
					que2.addAll(que1);
					que1.clear();
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
