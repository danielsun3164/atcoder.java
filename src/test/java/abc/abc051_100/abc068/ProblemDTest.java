package abc.abc051_100.abc068;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(0L);
	}

	@Test
	void case2() {
		check(1L);
	}

	@Test
	void case3() {
		check(2L);
	}

	@Test
	void case4() {
		check(3L);
	}

	@Test
	void case5() {
		check(12345L);
	}

	private void check(long k) {
		in.input(k);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		try {
			int n = Integer.parseInt(lines[0]);
			String[] numbers = lines[1].split("\\ ");
			assertEquals(n, numbers.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int n = scanner.nextInt();
			assertTrue((2 <= n) & (n <= 50), "n is " + n);
			long[] a = IntStream.range(0, n).mapToLong(i -> {
				long ai = scanner.nextLong();
				assertTrue((0 <= ai) && (ai <= 10_000_000_000_001_000L), "a[" + i + "] is " + ai);
				return ai;
			}).toArray();
			assertEquals(k, calc(a));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
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
