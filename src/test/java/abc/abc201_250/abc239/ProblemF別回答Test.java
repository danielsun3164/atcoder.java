package abc.abc201_250.abc239;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;
import testbase.library.DisjointSetUnion;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check(6, 2, new int[] { 1, 2, 1, 2, 2, 2 }, new int[] { 2, 1 }, new int[] { 3, 4 });
	}

	@Test
	void case2() {
		check("5 1\n" + "1 1 1 1 4\n" + "2 3", "-1");
	}

	@Test
	void case3() {
		check("4 0\n" + "3 3 3 3", "-1");
	}

	void check(int n, int m, int[] d, int[] a, int[] b) {
		in.input(n + " " + m);
		in.input(Arrays.stream(d).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		DisjointSetUnion dsu = new DisjointSetUnion(n);
		IntStream.range(0, m).forEach(i -> {
			in.input(a[i] + " " + b[i]);
			dsu.merge(a[i] - 1, b[i] - 1);
		});
		execute();
		int k = n - m - 1;
		String[] lines = out.toString().split("\\R");
		assertEquals(k, lines.length);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			IntStream.range(0, k).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				assertTrue((0 <= u) && (u < n));
				assertTrue((0 <= v) && (v < n));
				assertFalse(dsu.same(u, v));
				dsu.merge(u, v);
			});
			assertEquals(1, dsu.getGroupNum());
		} catch (IOException e) {
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/F", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int result = expectedScanner.nextInt();
				if (-1 == result) {
					check(inputIs, "-1");
				} else {
					int n = inputScanner.nextInt(), m = inputScanner.nextInt();
					int[] d = IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray();
					int[] a = new int[m], b = new int[m];
					IntStream.range(0, m).forEach(i -> {
						a[i] = inputScanner.nextInt();
						b[i] = inputScanner.nextInt();
					});
					check(n, m, d, a, b);
				}
			}
		});
	}
}
