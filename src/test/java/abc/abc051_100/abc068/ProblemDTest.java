package abc.abc051_100.abc068;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

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
		check(1234567894848L);
	}

	private void check(long k) {
		in.input(k);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		try {
			int n = Integer.parseInt(lines[0]);
			String[] numbers = lines[1].split("\\s+");
			assertEquals(n, numbers.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int n = scanner.nextInt();
			assertTrue((2 <= n) && (n <= 50), "n is " + n);
			long[] a = IntStream.range(0, n).mapToLong(i -> {
				long ai = scanner.nextLong();
				assertTrue((0 <= ai) && (ai <= 10_000_000_000_001_000L), "a[" + i + "] is " + ai);
				return ai;
			}).toArray();
			assertEquals(k, calc(a, k));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 入力配列に対して，操作を繰り返して実施する
	 *
	 * @param a 入力配列
	 * @param k 想定操作回数
	 * @return 操作の実施回数
	 */
	private long calc(long[] a, long k) {
		int n = a.length;
		// x回nを引く、(k-x)回1を足す ＝ x回(n+1)を引く、k回1を足す
		return Arrays.stream(a).map(ai -> (ai + k - (n - 1) + n) / (n + 1)).sum();
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC079/D", (inputIs, expectedIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				check(scanner.nextLong());
			}
		});
	}
}
