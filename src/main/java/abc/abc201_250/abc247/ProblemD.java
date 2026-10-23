package abc.abc201_250.abc247;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			Deque<Data> que = new ArrayDeque<>();
			// TLE対策のため、結果をStringBuilderに入れる
			StringBuilder sb = new StringBuilder();
			while (q-- > 0) {
				int t = scanner.nextInt();
				if (1 == t) {
					long x = scanner.nextLong(), c = scanner.nextLong();
					que.addLast(new Data(x, c));
				} else {
					long c = scanner.nextLong(), answer = 0L;
					while (!que.isEmpty() && que.peekFirst().c <= c) {
						Data data = que.pollFirst();
						answer += data.x * data.c;
						c -= data.c;
					}
					if (c > 0L) {
						Data data = que.peekFirst();
						answer += data.x * c;
						data.c -= c;
					}
					sb.append(answer).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}

	/**
	 * x,c を格納するクラス
	 */
	private static class Data {
		long x, c;

		Data(long x, long c) {
			this.x = x;
			this.c = c;
		}
	}
}
