package abc.abc201_250.abc217;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 解説通りに実装したソースコード
 *
 * https://atcoder.jp/contests/abc217/submissions/39945618 を参考に作成
 */
public class ProblemH {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), last = 0;
			Queue<Long> lQue = new PriorityQueue<>(Comparator.reverseOrder()), rQue = new PriorityQueue<>();
			IntStream.range(0, n).forEach(i -> {
				lQue.add(0L);
				rQue.add(0L);
			});
			long addL = 0L, addR = 0L, answer = 0L;
			while (n-- > 0) {
				int t = scanner.nextInt(), d = scanner.nextInt(), x = scanner.nextInt();
				addL -= t - last;
				addR += t - last;
				last = t;
				if (0 == d) {
					long r0 = rQue.peek();
					if (x >= r0 + addR) {
						answer += x - (r0 + addR);
					}
					rQue.add(x - addR);
					lQue.add(rQue.poll() + addR - addL);
				} else {
					long l0 = lQue.peek();
					if (x <= l0 + addL) {
						answer += (l0 + addL) - x;
					}
					lQue.add(x - addL);
					rQue.add(lQue.poll() + addL - addR);
				}
			}
			System.out.println(answer);
		}
	}
}
