package abc.abc151_200.abc200;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 余りを取るために割る数字 */
	private static final int N = 200;

	@Test
	void case1() {
		check(5, new int[] { 180, 186, 189, 191, 218 });
	}

	@Test
	void case2() {
		check(2, new int[] { 123, 523 });
	}

	void check(int n, int[] a) {
		in.input(n);
		in.input(Arrays.stream(a).mapToObj(ai -> String.valueOf(ai)).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(3, lines.length);
		check(lines[1]);
		check(lines[2]);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			String result = scanner.next();
			assertEquals("Yes", result);
			int nb = scanner.nextInt();
			int[] b = IntStream.range(0, nb).map(i -> scanner.nextInt() - 1).toArray();
			int bBit = Arrays.stream(b).map(bi -> (1 << bi)).sum();
			int nc = scanner.nextInt();
			int[] c = IntStream.range(0, nc).map(i -> scanner.nextInt() - 1).toArray();
			int cBit = Arrays.stream(c).map(ci -> (1 << ci)).sum();
			assertNotEquals(bBit, cBit);
			int bSum = Arrays.stream(b).map(bi -> a[bi] % N).sum() % N;
			int cSum = Arrays.stream(c).map(ci -> a[ci] % N).sum() % N;
			assertEquals(bSum, cSum);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	private void check(String line) {
		String[] numbers = line.split("\\ ");
		assertTrue(numbers.length > 0);
		try {
			int n = Integer.parseInt(numbers[0]);
			assertEquals(n + 1, numbers.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	void case3() {
		check("6\n" + "2013 1012 2765 2021 508 6971", "No");
	}
}
