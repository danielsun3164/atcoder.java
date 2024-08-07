package abc.abc201_250.abc233;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
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

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check(6, new int[] { 5, 3, 2, 4, 6, 1 }, 4, new int[] { 1, 5, 1, 2 }, new int[] { 5, 6, 2, 3 });
	}

	@Test
	void case2() {
		check("5\n" + "3 4 1 2 5\n" + "2\n" + "1 3\n" + "2 5", "-1");
	}

	@Test
	void case3() {
		check(4, new int[] { 1, 2, 3, 4 }, 6, new int[] { 1, 1, 1, 2, 2, 3 }, new int[] { 2, 3, 4, 3, 4, 4 });
	}

	void check(int n, int[] p, int m, int[] a, int[] b) {
		in.input(n);
		in.input(Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		in.input(m);
		IntStream.range(0, m).forEach(i -> in.input(a[i] + " " + b[i]));
		execute();
		int[] expected = IntStream.rangeClosed(1, n).toArray();
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int k = scanner.nextInt();
			assertTrue(k <= 5E5);
			IntStream.range(0, k).forEach(i -> {
				int c = scanner.nextInt() - 1;
				swap(p, a[c] - 1, b[c] - 1);
			});
			assertArrayEquals(expected, p);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/F", (inputIs, expectedIs) -> {
			try (Scanner expectedScanner = new Scanner(expectedIs)) {
				int result = expectedScanner.nextInt();
				if (-1 == result) {
					check(inputIs, "-1");
				} else {
					try (Scanner inputScanner = new Scanner(inputIs)) {
						int n = inputScanner.nextInt();
						int[] p = IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray();
						int m = inputScanner.nextInt();
						int[] a = new int[m], b = new int[m];
						IntStream.range(0, m).forEach(i -> {
							a[i] = inputScanner.nextInt();
							b[i] = inputScanner.nextInt();
						});
						check(n, p, m, a, b);
					}
				}
			}
		});
	}
}
