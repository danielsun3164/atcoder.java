package abc068;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() throws Exception {
		check(0L);
	}

	@Test
	void case2() throws Exception {
		check(1L);
	}

	@Test
	void case3() throws Exception {
		check(2L);
	}

	@Test
	void case4() throws Exception {
		check(3L);
	}

	@Test
	void case5() throws Exception {
		check(12345L);
	}

	private void check(long value) throws IOException {
		in.input(value);
		ProblemD.main(null);
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			int n = scanner.nextInt();
			long[] a = new long[n];
			IntStream.range(0, n).forEach(i -> a[i] = scanner.nextLong());
			assertEquals(value, calc(a));
		}
	}

	/**
	 * 入力配列に対して，操作を繰り返して実施する
	 * 
	 * @param a 入力配列
	 * @return 操作の実施回数
	 */
	private long calc(long[] a) {
		int n = a.length;
		long result = 0L;
		Queue<Long> queue = new PriorityQueue<Long>((x, y) -> y.compareTo(x));
		Arrays.stream(a).forEach(ai -> queue.add(ai));
		while (true) {
			if (queue.peek() <= n - 1 - result) {
				break;
			}
			queue.add(queue.poll() - n - 1);
			result++;
		}
		return result;
	}
}
