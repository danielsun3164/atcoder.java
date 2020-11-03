package abc.abc108;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() throws IOException {
		check(4);
	}

	@Test
	void case2() throws IOException {
		check(5);
	}

	@Test
	void case3() throws IOException {
		check(1000000);
	}

	private void check(int l) throws IOException {
		in.input(l);
		ProblemD.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int n = scanner.nextInt(), m = scanner.nextInt();
			assertTrue(n <= 20, "n is " + n);
			assertTrue(m <= 60, "m is " + m);
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
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
}
