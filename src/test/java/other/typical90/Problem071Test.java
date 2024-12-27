package other.typical90;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem071Test extends TestBase {

	@Test
	void case1() {
		check(5, 2, 3, new int[] { 1, 3 }, new int[] { 2, 4 }, 3);
	}

	private void check(int n, int m, int k, int[] a, int[] b, int k2) {
		in.input(n + " " + m + " " + k);
		IntStream.range(0, m).forEach(i -> in.input(a[i] + " " + b[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(k2, lines.length);
		IntStream.range(0, k2).forEach(i -> {
			String[] numbers = lines[i].split("\\s+");
			assertEquals(n, numbers.length);
			Set<Integer> set = new HashSet<>();
			int[] indexes = new int[n + 1];
			for (int j = 0; j < n; j++) {
				try {
					int number = Integer.parseInt(numbers[j]);
					set.add(number);
					indexes[number] = j;
				} catch (NumberFormatException e) {
					fail(e);
				}
			}
			assertEquals(n, set.size());
			IntStream.range(0, m).forEach(j -> assertTrue(indexes[a[j]] < indexes[b[j]],
					a[j] + " is after " + b[j] + ", " + indexes[a[j]] + ", " + indexes[b[j]]));
		});
	}

	@Test
	void case2() {
		check("5 2 1\n" + "1 3\n" + "3 1", "-1");
	}

	@Test
	void case3() {
		check(10, 15, 10, new int[] { 8, 9, 10, 6, 10, 1, 7, 6, 8, 5, 10, 3, 8, 3, 2 },
				new int[] { 4, 4, 2, 2, 6, 3, 4, 8, 1, 6, 9, 7, 3, 9, 3 }, 10);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/071", (inputIs, expectedIs) -> {
			try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				byte[] buffer = new byte[8192];
				int length = 0;
				while ((length = expectedIs.read(buffer)) > 0) {
					baos.write(buffer, 0, length);
				}
				try (Scanner inScanner = new Scanner(inputIs);
						ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
						Scanner expectedScanner = new Scanner(bais)) {
					int exp = expectedScanner.nextInt();
					if (-1 == exp) {
						check(inputIs, "-1");
					} else {
						int n = inScanner.nextInt(), m = inScanner.nextInt(), k = inScanner.nextInt();
						int[] a = new int[m], b = new int[m];
						IntStream.range(0, m).forEach(i -> {
							a[i] = inScanner.nextInt();
							b[i] = inScanner.nextInt();
						});
						String[] lines = baos.toString().split("\\R");
						check(n, m, k, a, b, lines.length);
					}
				}
			} catch (IOException e) {
				fail(e);
			}
		});
	}
}
