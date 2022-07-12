package abc.abc151_200.abc200;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

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
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(3, lines.length);
		check(lines[1]);
		check(lines[2]);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			String result = scanner.next();
			assertTrue("Yes".equalsIgnoreCase(result));
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
			fail(e);
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

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc200/D", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner expectedScanner = new Scanner(expectedIs)) {
			String result = expectedScanner.next();
			if ("No".equalsIgnoreCase(result)) {
				check(inputIs, "No");
			} else {
				try (Scanner inputScanner = new Scanner(inputIs)) {
					int n = inputScanner.nextInt();
					int[] a = IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray();
					check(n, a);
				}
			}
		}
	}
}
