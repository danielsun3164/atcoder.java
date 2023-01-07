package other.typical90;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem088Test extends TestBase {

	@Test
	void case1() {
		check(5, 2, new int[] { 3, 1, 3, 2, 3 }, new int[] { 1, 1 }, new int[] { 2, 4 });
	}

	@Test
	void case2() {
		check(10, 10, new int[] { 2, 5, 7, 8, 11, 10, 1, 88, 86, 50 }, new int[] { 1, 1, 1, 1, 1, 5, 6, 2, 9, 7 },
				new int[] { 2, 3, 4, 5, 6, 10, 10, 3, 10, 8 });
	}

	void check(int n, int q, int[] a, int[] x, int[] y) {
		in.input(n + " " + q);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		IntStream.range(0, q).forEach(i -> in.input(x[i] + " " + y[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(4, lines.length);
		IntStream.of(0, 2).forEach(i -> {
			try {
				int count = Integer.parseInt(lines[i]);
				String[] numbers = lines[i + 1].split("\\s");
				assertEquals(count, numbers.length);
			} catch (NumberFormatException e) {
				fail(e);
			}
		});
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int bx = scanner.nextInt();
			int[] b = new int[bx];
			IntStream.range(0, bx).forEach(i -> {
				b[i] = scanner.nextInt() - 1;
				assertTrue((0 <= b[i]) && (b[i] < n));
				if (i > 0) {
					assertTrue(b[i] > b[i - 1]);
				}
			});
			int cy = scanner.nextInt();
			int[] c = new int[cy];
			IntStream.range(0, cy).forEach(i -> {
				c[i] = scanner.nextInt() - 1;
				assertTrue((0 <= c[i]) && (c[i] < n));
				if (i > 0) {
					assertTrue(c[i] > c[i - 1]);
				}
			});
			assertEquals(Arrays.stream(b).map(bi -> a[bi]).sum(), Arrays.stream(c).map(ci -> a[ci]).sum());
			Set<Integer> bSet = Arrays.stream(b).boxed().collect(Collectors.toSet());
			Set<Integer> cSet = Arrays.stream(c).boxed().collect(Collectors.toSet());
			assertFalse(bSet.equals(cSet));
			IntStream.range(0, q).forEach(i -> {
				assertFalse(bSet.contains(x[i] - 1) && bSet.contains(y[i] - 1));
				assertFalse(cSet.contains(x[i] - 1) && cSet.contains(y[i] - 1));
			});
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner scanner = new Scanner(inputIs)) {
			int n = scanner.nextInt(), q = scanner.nextInt();
			int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] x = new int[q], y = new int[q];
			IntStream.range(0, q).forEach(i -> {
				x[i] = scanner.nextInt();
				y[i] = scanner.nextInt();
			});
			check(n, q, a, x, y);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/088", this::check);
	}
}
