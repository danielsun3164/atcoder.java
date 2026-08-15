package abc.abc201_250.abc240;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check(3, new int[] { 2, 3 }, new int[] { 1, 1 }, new int[] { 1, 0, 0 }, 2);
	}

	@Test
	void case2() {
		check(5, new int[] { 3, 5, 1, 1 }, new int[] { 4, 4, 2, 4 }, new int[] { 2, 0, 0, 1, 0 }, 3);
	}

	@Test
	void case3() {
		check(5, new int[] { 4, 3, 5, 3 }, new int[] { 5, 2, 2, 1 }, new int[] { 0, 0, 0, 0, 0 }, 1);
	}

	void check(int n, int[] a, int[] b, int[] diff, int expectedMax) {
		in.input(n);
		IntStream.range(0, n - 1).forEach(i -> in.input(a[i] + " " + b[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(n, lines.length);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int[] l = new int[n], r = new int[n];
			int actualMax = IntStream.range(0, n).map(i -> {
				l[i] = scanner.nextInt();
				assertTrue((1 <= l[i]) && (l[i] <= n));
				r[i] = scanner.nextInt();
				assertTrue((1 <= r[i]) && (r[i] <= n));
				assertEquals(diff[i], r[i] - l[i]);
				return Math.max(l[i], r[i]);
			}).max().getAsInt();
			assertEquals(expectedMax, actualMax);
		} catch (IOException e) {
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/E", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int n = inputScanner.nextInt();
				int[] a = new int[n - 1], b = new int[n - 1];
				IntStream.range(0, n - 1).forEach(i -> {
					a[i] = inputScanner.nextInt();
					b[i] = inputScanner.nextInt();
				});
				int[] l = new int[n], r = new int[n], diff = new int[n];
				int expectedMax = IntStream.range(0, n).map(i -> {
					l[i] = expectedScanner.nextInt();
					r[i] = expectedScanner.nextInt();
					diff[i] = r[i] - l[i];
					return Math.max(l[i], r[i]);
				}).max().getAsInt();
				check(n, a, b, diff, expectedMax);
			}
		});
	}
}
