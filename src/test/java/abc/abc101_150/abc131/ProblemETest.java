package abc.abc101_150.abc131;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	/** 初期化用大きい値 */
	private static final int INF = Integer.MAX_VALUE >> 1;

	@Test
	void case1() {
		check(5, 3);
	}

	private void check(int n, int k) {
		in.input(n + " " + k);
		execute();
		String[] lines = out.toString().split("\\R");
		assertTrue(lines.length > 0, "line is empty");
		try {
			int m = Integer.parseInt(lines[0]);
			assertEquals(m + 1, lines.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int[][] d = new int[n][n];
			IntStream.range(0, n).forEach(i -> {
				Arrays.fill(d[i], INF);
				d[i][i] = 0;
			});
			int m = scanner.nextInt();
			IntStream.range(0, m).forEach(i -> {
				int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
				// グラフが単純であることの確認
				assertEquals(INF, d[u][v]);
				assertEquals(INF, d[v][u]);
				d[u][v] = d[v][u] = 1;
			});
			IntStream.range(0, n).forEach(l -> IntStream.range(0, n)
					.forEach(j -> IntStream.range(0, n).forEach(i -> d[i][j] = Math.min(d[i][j], d[i][l] + d[l][j]))));
			// 最短距離が2であるような頂点対 (i,j)(i<j)が、ちょうど K個存在することの確認
			assertEquals(k, IntStream.range(0, n - 1)
					.map(i -> (int) IntStream.range(i + 1, n).filter(j -> 2 == d[i][j]).count()).sum());
			// グラフが連結であることの確認
			assertEquals(0, IntStream.range(0, n - 1)
					.map(i -> (int) IntStream.range(i + 1, n).filter(j -> INF == d[i][j]).count()).sum());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	void case2() {
		check("5 8", "-1");
	}

	@Test
	void case3() {
		check(6, 10);
	}

	@Test
	void case4() {
		check(100, 0);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC131/E", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int result = expectedScanner.nextInt();
				if (-1 == result) {
					check(inputIs, "-1");
					return;
				}
				check(inputScanner.nextInt(), inputScanner.nextInt());
			}
		});
	}
}
