package abc.abc201_250.abc221;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答Test extends TestBase {

	/** X座標の差分 */
	private static final int[] XS = { 0, 0, -1, 1 };
	/** Y座標の差分 */
	private static final int[] YS = { 1, -1, 0, 0 };
	/** UDLRをXS、YSのインデックスへ変換するマップ */
	private static final Map<Character, Integer> MAP = Map.of('U', 0, 'D', 1, 'L', 2, 'R', 3);

	@Test
	void case1() {
		check(3, 2, -2, new int[] { 1, 2, 3 });
	}

	@Test
	void case2() {
		check("2 1 0\n" + "1 6", "No");
	}

	@Test
	void case3() {
		check(5, 6, 7, new int[] { 1, 3, 5, 7, 9 });
	}

	void check(int n, int a, int b, int[] d) {
		in.input(n + " " + a + " " + b);
		in.input(Arrays.stream(d).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			String result = scanner.next();
			assertEquals("Yes", result);
			char[] answer = scanner.next().toCharArray();
			assertEquals(n, answer.length);
			int x = 0, y = 0;
			for (int i = 0; i < n; i++) {
				char c = answer[i];
				assertTrue(MAP.containsKey(c));
				x += XS[MAP.get(c)] * d[i];
				y += YS[MAP.get(c)] * d[i];
			}
			assertEquals(a, x);
			assertEquals(b, y);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/G", (inputIs, expectedIs) -> {
			try (Scanner expectedScanner = new Scanner(expectedIs)) {
				String result = expectedScanner.next();
				if ("No".equals(result)) {
					check(inputIs, "No");
				} else {
					try (Scanner inputScanner = new Scanner(inputIs)) {
						int n = inputScanner.nextInt(), a = inputScanner.nextInt(), b = inputScanner.nextInt();
						int[] d = IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray();
						check(n, a, b, d);
					}
				}
			}
		});
	}
}
