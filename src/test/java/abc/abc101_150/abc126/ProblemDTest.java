package abc.abc101_150.abc126;

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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import abc.abc101_150.abc126.ProblemD.Path;
import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 0,1の文字列のパターン */
	private static Pattern PATTERN = Pattern.compile("[01]");

	@Test
	void case1() {
		check(3, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 1 });
	}

	@Test
	void case2() {
		check(5, new int[] { 2, 2, 1, 3 }, new int[] { 5, 3, 3, 4 }, new int[] { 2, 10, 8, 2 });
	}

	void check(int n, int[] u, int[] v, int[] w) {
		in.input(n);
		IntStream.range(0, n - 1).forEach(i -> in.input(u[i] + " " + v[i] + " " + w[i]));
		@SuppressWarnings("unchecked")
		List<Path>[] paths = new List[n];
		IntStream.range(0, n).forEach(i -> paths[i] = new ArrayList<>());
		IntStream.range(0, n - 1).forEach(i -> {
			paths[u[i] - 1].add(new Path(v[i] - 1, w[i]));
			paths[v[i] - 1].add(new Path(u[i] - 1, w[i]));
		});
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(n, lines.length);
		Arrays.stream(lines).forEach(line -> assertTrue(PATTERN.matcher(line).matches()));
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int[] answer = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			int[] whites = Arrays.stream(answer).filter(i -> (0 == i)).toArray();
			check(n, paths, whites);
			int[] blacks = Arrays.stream(answer).filter(i -> (1 == i)).toArray();
			check(n, paths, blacks);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	private void check(int n, List<Path>[] paths, int[] nodes) {
		if (nodes.length > 0) {
			long[] distances = new long[n];
			Arrays.fill(distances, Long.MAX_VALUE >> 1);
			int source = nodes[0];
			Queue<Path> que = new PriorityQueue<>();
			que.add(new Path(source, 0));
			distances[source] = 0L;
			while (!que.isEmpty()) {
				Path now = que.poll();
				for (Path path : paths[now.to]) {
					if (distances[path.to] < distances[now.to] + path.cost) {
						distances[path.to] = distances[now.to] + path.cost;
						que.add(new Path(path.to, distances[path.to]));
					}
				}
			}
			Arrays.stream(nodes).forEach(node -> assertEquals(0L, 1L & distances[node]));
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC126/D", (inputIs, expectedIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				int n = scanner.nextInt();
				int[] u = new int[n - 1], v = new int[n - 1], w = new int[n - 1];
				IntStream.range(0, n - 1).forEach(i -> {
					u[i] = scanner.nextInt();
					v[i] = scanner.nextInt();
					w[i] = scanner.nextInt();
				});
				check(n, u, v, w);
			}
		});
	}
}
