package other.tessoku_book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemB62Test extends TestBase {

	@Test
	void case1() {
		check(5, 4, new int[] { 1, 2, 3, 3 }, new int[] { 2, 3, 4, 5 });
	}

	void check(int n, int m, int[] a, int[] b) {
		in.input(n + " " + m);
		@SuppressWarnings("unchecked")
		Set<Integer>[] edges = new Set[n + 1];
		IntStream.rangeClosed(1, n).forEach(i -> edges[i] = new HashSet<>());
		IntStream.range(0, m).forEach(i -> {
			in.input(a[i] + " " + b[i]);
			edges[a[i]].add(b[i]);
			edges[b[i]].add(a[i]);
		});
		execute();
		String[] lines = new String(out.toByteArray()).split("\\R");
		assertEquals(1, lines.length);
		String[] v = lines[0].split("\\s+");
		int k = v.length;
		int[] answers = new int[k];
		Set<Integer> history = new HashSet<>();
		IntStream.range(0, k).forEach(i -> answers[i] = Integer.parseInt(v[i]));
		assertEquals(1, answers[0]);
		history.add(answers[0]);
		IntStream.range(1, k).forEach(i -> {
			assertTrue(edges[answers[i - 1]].contains(answers[i]));
			assertFalse(history.contains(answers[i]));
			history.add(answers[i]);
		});
		assertEquals(n, answers[k - 1]);
	}

	@Test
	void case2() {
		check(15, 30,
				new int[] { 6, 9, 2, 9, 2, 1, 4, 1, 4, 1, 9, 2, 3, 5, 4, 11, 1, 4, 8, 9, 5, 3, 8, 2, 9, 1, 2, 6, 7, 9 },
				new int[] { 9, 10, 9, 12, 14, 4, 6, 3, 14, 6, 11, 6, 9, 9, 9, 15, 13, 13, 9, 13, 15, 5, 10, 4, 14, 9, 8,
						13, 9, 15 });
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("tessoku-book/B62", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs)) {
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
