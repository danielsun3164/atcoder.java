package abc.abc101_150.abc111;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** wを表す正規表現 */
	private static final Pattern PATTERN = Pattern.compile("^[LRDU]+");

	@Test
	void case1() {
		check(3, new int[] { -1, 0, 2 }, new int[] { 0, 3, -1 });
	}

	@Test
	void case2() {
		check("5\n" + "0 0\n" + "1 0\n" + "2 0\n" + "3 0\n" + "4 0", "-1");
	}

	@Test
	void case3() {
		check(2, new int[] { 1, 1 }, new int[] { 1, 1 });
	}

	private void check(int n, int[] x, int[] y) {
		in.input(n);
		IntStream.range(0, n).forEach(i -> in.input(x[i] + " " + y[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(n + 2, lines.length);
		try {
			int m = Integer.parseInt(lines[0]);
			String[] numbers = lines[1].split("\\s+");
			assertEquals(m, numbers.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int m = scanner.nextInt();
			int[] d = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
			IntStream.range(0, n).forEach(i -> {
				String w = scanner.next();
				assertEquals(m, w.length());
				assertTrue(PATTERN.matcher(w).matches(), "w is " + w);
				check(m, d, w.toCharArray(), x[i], y[i]);
			});
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	/**
	 * 指定されたモードで関節mが(expectedX,expectedY)にあるかをチェック
	 *
	 * @param m         腕数
	 * @param d         腕の長さの配列
	 * @param w         モード
	 * @param expectedX
	 * @param expectedY
	 */
	private void check(int m, int[] d, char[] w, int expectedX, int expectedY) {
		int x = 0, y = 0;
		for (int i = 0; i < m; i++) {
			switch (w[i]) {
			case 'L' -> x -= d[i];
			case 'R' -> x += d[i];
			case 'D' -> y -= d[i];
			case 'U' -> y += d[i];
			}
		}
		assertEquals(expectedX, x);
		assertEquals(expectedY, y);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC111/D", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int m = expectedScanner.nextInt();
				if (-1 == m) {
					check(inputIs, "-1");
					return;
				}
				int n = inputScanner.nextInt();
				int[] x = new int[n], y = new int[n];
				IntStream.range(0, n).forEach(i -> {
					x[i] = inputScanner.nextInt();
					y[i] = inputScanner.nextInt();
				});
				check(n, x, y);
			}
		});
	}
}
