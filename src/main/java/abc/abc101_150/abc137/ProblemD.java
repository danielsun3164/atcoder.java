package abc.abc101_150.abc137;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemD {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			Queue<Data> allQue = new PriorityQueue<>((x, y) -> Integer.compare(x.a, y.a));
			IntStream.range(0, n).forEach(i -> allQue.add(new Data(scanner.nextInt(), scanner.nextInt())));
			Queue<Data> workQue = new PriorityQueue<>((x, y) -> Integer.compare(y.b, x.b));
			System.out.println(IntStream.rangeClosed(1, m).mapToLong(i -> {
				while (!allQue.isEmpty() && (allQue.peek().a <= i)) {
					workQue.add(allQue.poll());
				}
				return (workQue.isEmpty()) ? 0L : workQue.poll().b;
			}).sum());
		}
	}

	/**
	 * a,bを表すクラス
	 */
	private static class Data {
		int a, b;

		Data(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
