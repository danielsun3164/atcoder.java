package abc.abc201_250.abc212;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int q = scanner.nextInt();
			Queue<Long> que = new PriorityQueue<>();
			// TLE対策のため、結果をStringBuilderにまとめる
			StringBuilder sb = new StringBuilder();
			long diff = 0L;
			for (int i = 0; i < q; i++) {
				int p = scanner.nextInt();
				if (1 == p) {
					long x = scanner.nextLong();
					que.add(x - diff);
				} else if (2 == p) {
					long x = scanner.nextLong();
					diff += x;
				} else {
					sb.append(que.poll() + diff).append(System.lineSeparator());
				}
			}
			System.out.print(sb.toString());
			System.out.flush();
		}
	}
}
