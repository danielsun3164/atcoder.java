package abc.abc151_200.abc178;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(6, new int[] { 1, 1, 1, 2, 2, 3 }, new int[] { 1, 1, 1, 2, 2, 3 }, true);
	}

	@Test
	void case2() {
		check(3, new int[] { 1, 1, 2 }, new int[] { 1, 1, 3 }, false);
	}

	@Test
	void case3() {
		check(4, new int[] { 1, 1, 2, 3 }, new int[] { 1, 2, 3, 3 }, true);
	}

	private void check(int n, int[] a, int[] b, boolean expected) {
		in.input(n);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		in.input(Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		if (expected) {
			assertEquals(2, lines.length);
			String[] numbers = lines[1].split("\\ ");
			assertEquals(n, numbers.length);
		} else {
			assertEquals(1, lines.length);
		}
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			String result = scanner.next();
			if (expected) {
				assertEquals("Yes", result);
				int[] newB = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
				// a[i]とnewB[i]が異なることを判定
				IntStream.range(0, n).forEach(i -> assertNotEquals(a[i], newB[i]));
				// bとnewBは同じものを判定
				Arrays.sort(b);
				Arrays.sort(newB);
				assertArrayEquals(b, newB);
			} else {
				assertEquals("No", result);
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
