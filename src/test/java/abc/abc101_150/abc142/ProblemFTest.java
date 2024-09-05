package abc.abc101_150.abc142;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(4, 5, new int[] { 1, 2, 2, 4, 4 }, new int[] { 2, 3, 4, 1, 3 });
	}

	@Test
	void case2() {
		check("4 5\n" + "1 2\n" + "2 3\n" + "2 4\n" + "1 4\n" + "4 3", "-1");
	}

	@Test
	void case3() {
		check(6, 9, new int[] { 1, 2, 3, 4, 5, 5, 5, 6, 6 }, new int[] { 2, 3, 4, 5, 6, 1, 2, 1, 2 });
	}

	private void check(int n, int m, int[] a, int[] b) {
		in.input(n + " " + m);
		IntStream.range(0, m).forEach(i -> in.input(a[i] + " " + b[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertTrue(lines.length > 0, "line is empty");
		try {
			int k = Integer.parseInt(lines[0]);
			assertEquals(k + 1, lines.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int k = scanner.nextInt();
			Set<Integer> vSet = IntStream.range(0, k).map(i -> {
				int v = scanner.nextInt();
				assertTrue((v >= 1) && (v <= n), "v is " + v);
				return v;
			}).boxed().collect(Collectors.toSet());
			Map<Integer, Integer> inMap = new HashMap<>(), outMap = new HashMap<>();
			IntStream.range(0, m).filter(i -> vSet.contains(a[i]) && vSet.contains(b[i])).forEach(i -> {
				outMap.put(a[i], outMap.getOrDefault(a[i], 0) + 1);
				inMap.put(b[i], inMap.getOrDefault(b[i], 0) + 1);
			});
			assertEquals(k, inMap.size());
			assertEquals(k, outMap.size());
			assertEquals(1, inMap.values().stream().mapToInt(Integer::intValue).max().getAsInt());
			assertEquals(1, inMap.values().stream().mapToInt(Integer::intValue).min().getAsInt());
			assertEquals(1, outMap.values().stream().mapToInt(Integer::intValue).max().getAsInt());
			assertEquals(1, outMap.values().stream().mapToInt(Integer::intValue).min().getAsInt());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC142/F", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int k = expectedScanner.nextInt();
				if (-1 == k) {
					check(inputIs, "-1");
					return;
				}
				int n = inputScanner.nextInt(), m = inputScanner.nextInt();
				int[] a = new int[m], b = new int[m];
				IntStream.range(0, m).forEach(i -> {
					a[i] = inputScanner.nextInt();
					b[i] = inputScanner.nextInt();
				});
				check(n, m, a, b);
			}
		});
	}
}
