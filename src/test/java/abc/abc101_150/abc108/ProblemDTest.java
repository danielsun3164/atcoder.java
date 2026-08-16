package abc.abc101_150.abc108;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(4);
	}

	@Test
	void case2() {
		check(5);
	}

	@Test
	void case3() {
		check(1000000);
	}

	private void check(int l) {
		in.input(l);
		execute();
		String[] lines = out.toString().split("\\R");
		assertTrue(lines.length > 0, "line is empty");
		String[] numbers = lines[0].split("\\s+");
		assertEquals(2, numbers.length);
		try {
			int n = Integer.parseInt(numbers[0]), m = Integer.parseInt(numbers[1]);
			assertTrue(n <= 20, "n is " + n);
			assertTrue(m <= 60, "m is " + m);
			assertEquals(m + 1, lines.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			@SuppressWarnings("unchecked")
			List<Path>[] paths = new List[n];
			IntStream.range(0, n).forEach(i -> paths[i] = new ArrayList<>());
			IntStream.range(0, m).forEach(i -> {
				int from = scanner.nextInt() - 1, to = scanner.nextInt() - 1;
				int cost = scanner.nextInt();
				paths[from].add(new Path(from, to, cost));
			});
			// counts[i]はcostがiのパスの数
			int[] counts = new int[l];
			Arrays.fill(counts, 0);
			calcCounts(0, n - 1, paths, counts, 0);
			int[] expected = new int[l];
			Arrays.fill(expected, 1);
			assertArrayEquals(expected, counts);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 起点から終点までのすべてのパスのコストを計算する
	 *
	 * @param source      起点
	 * @param destination 終点
	 * @param paths       パスの配列
	 * @param counts      パスのコストの配列
	 * @param currentCost 現在のコスト
	 */
	private void calcCounts(int source, int destination, List<Path>[] paths, int[] counts, int currentCost) {
		if (source == destination) {
			counts[currentCost]++;
			return;
		}
		for (Path path : paths[source]) {
			calcCounts(path.to, destination, paths, counts, currentCost + path.cost);
		}
	}

	/**
	 * パスを表すクラス
	 */
	private static class Path {
		@SuppressWarnings("unused")
		int from;
		int to;
		int cost;

		Path(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC108/D", (inputIs, expectedIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				check(scanner.nextInt());
			}
		});
	}
}
