package abc.abc051_100.abc081;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(new int[] { -2, 5, -1 });
	}

	@Test
	void case2() {
		check(new int[] { -1, -3 });
	}

	@Test
	void case3() {
		check("5\n" + "0 0 0 0 0", "0");
	}

	private void check(int[] a) {
		in.input(a.length);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertTrue(lines.length > 0, "no lines");
		try {
			int m = Integer.parseInt(lines[0]);
			assertEquals(m + 1, lines.length);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			fail(e);
		}
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			int m = scanner.nextInt();
			IntStream.range(0, m).forEach(i -> {
				int x = scanner.nextInt() - 1;
				a[scanner.nextInt() - 1] += a[x];
			});
			assertTrue(isIncreasing(a));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC086/D", (inputIs, expectedIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				int n = scanner.nextInt();
				check(IntStream.range(0, n).map(i -> scanner.nextInt()).toArray());
			}
		});
	}

	/**
	 * @param a 入力配列
	 * @return 入力配列は単調増加かどうか
	 */
	private static boolean isIncreasing(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
