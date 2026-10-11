package abc.abc201_250.abc244;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check(6, 6, new int[] { 6, 2, 4, 1, 6, 3 }, new int[] { 3, 5, 2, 3, 5, 2 }, "110001");
	}

	@Test
	void case2() {
		check(3, 3, new int[] { 3, 3, 1 }, new int[] { 1, 2, 2 }, "000");
	}

	void check(int n, int m, int[] u, int[] v, String s) {
		in.input(n + " " + m);
		@SuppressWarnings("unchecked")
		Set<Integer>[] edges = new Set[n];
		IntStream.range(0, n).forEach(i -> edges[i] = new HashSet<>());
		IntStream.range(0, m).forEach(i -> {
			in.input(u[i] + " " + v[i]);
			edges[u[i] - 1].add(v[i] - 1);
			edges[v[i] - 1].add(u[i] - 1);
		});
		in.input(s);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		int actualK = Integer.parseInt(lines[0]);
		assertTrue(actualK <= 4 * n);
		if (0 == actualK) {
			assertTrue(lines[1].isEmpty());
		} else {
			String[] numbers = lines[1].split("\\s+");
			assertEquals(actualK, numbers.length);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int k = scanner.nextInt();
			int[] a = IntStream.range(0, k).map(_ -> {
				int ai = scanner.nextInt();
				assertTrue((1 <= ai) && (ai <= n));
				return ai - 1;
			}).toArray();
			int[] count = new int[n];
			Arrays.fill(count, 0);
			IntStream.range(0, k).forEach(i -> {
				count[a[i]]++;
				if (i > 0) {
					assertTrue(edges[a[i - 1]].contains(a[i]));
				}
			});
			IntStream.range(0, n).forEach(i -> assertEquals(s.charAt(i) - '0', count[i] & 1));
		} catch (IOException e) {
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/G", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs)) {
				int n = inputScanner.nextInt(), m = inputScanner.nextInt();
				int[] u = new int[m], v = new int[m];
				IntStream.range(0, m).forEach(i -> {
					u[i] = inputScanner.nextInt();
					v[i] = inputScanner.nextInt();
				});
				String s = inputScanner.next();
				check(n, m, u, v, s);
			}
		});
	}
}
