package abc.abc201_250.abc227;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class ProblemHTest extends TestBase {

	/** マスの幅 */
	private static final int N = 3;

	@Test
	void case1() {
		check(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 2, 1 } });
	}

	@Test
	void case2() {
		check("2 4 2\n" + "2 1 1\n" + "1 1 2", "NO");
	}

	@Test
	void case3() {
		check(new int[][] { { 2, 2, 3 }, { 2, 1, 2 }, { 1, 3, 2 } });
	}

	void check(int[][] a) {
		Arrays.stream(a)
				.forEach(ai -> in.input(Arrays.stream(ai).mapToObj(String::valueOf).collect(Collectors.joining(" "))));
		execute();
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int x = 0, y = 0;
			char[] result = scanner.next().toCharArray();
			for (int c : result) {
				assertTrue(a[x][y] > 0);
				a[x][y]--;
				if ('L' == c) {
					assertTrue(y > 0);
					y--;
				} else if ('R' == c) {
					assertTrue(y < N - 1);
					y++;
				} else if ('U' == c) {
					assertTrue(x > 0);
					x--;
				} else {
					assertTrue(x < N - 1);
					x++;
				}
			}
			assertEquals(0, x);
			assertEquals(0, y);
			IntStream.range(0, N).forEach(i -> IntStream.range(0, N).forEach(j -> assertEquals(0, a[i][j])));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/H", (inputIs, expectedIs) -> {
			try (Scanner expectedScanner = new Scanner(expectedIs)) {
				String result = expectedScanner.next();
				if ("NO".equals(result)) {
					check(inputIs, "NO");
				} else {
					try (Scanner inputScanner = new Scanner(inputIs)) {
						int[][] a = IntStream.range(0, N)
								.mapToObj(i -> IntStream.range(0, N).map(j -> inputScanner.nextInt()).toArray())
								.toArray(int[][]::new);
						check(a);
					}
				}
			}
		});
	}
}
