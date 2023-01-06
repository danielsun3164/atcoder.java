package other.typical90;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

class Problem026Test extends TestBase {

	@Test
	void case1() {
		check(4, new int[] { 1, 2, 2 }, new int[] { 2, 3, 4 });
	}

	@Test
	void case2() {
		check(6, new int[] { 1, 2, 3, 2, 3 }, new int[] { 3, 4, 5, 5, 6 });
	}

	private void check(int n, int[] a, int[] b) {
		in.input(n);
		IntStream.range(0, n - 1).forEach(i -> in.input(a[i] + " " + b[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(n >> 1, lines.length);
		Set<Integer> set = Arrays.stream(lines).map(Integer::valueOf).map(i -> {
			assertTrue((1 <= i) && (i <= n), "i is " + i);
			return i;
		}).collect(Collectors.toSet());
		assertEquals(n >> 1, set.size());
		IntStream.range(0, n - 1).forEach(i -> assertFalse(set.contains(a[i]) && set.contains(b[i])));
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/026", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner scanner = new Scanner(inputIs)) {
			int n = scanner.nextInt();
			int[] a = new int[n - 1], b = new int[n - 1];
			IntStream.range(0, n - 1).forEach(i -> {
				a[i] = scanner.nextInt();
				b[i] = scanner.nextInt();
			});
			check(n, a, b);
		}
	}
}
