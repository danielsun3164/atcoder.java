package abc.abc151_200.abc180;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-9d;

	@Test
	void case1() {
		check(new int[] { 2, -1 }, 3, 2.236067977499790d, 2);
	}

	@Test
	void case2() {
		check(new int[] { 3, -1, -4, 1, -5, 9, 2, -6, 5, -3 }, 39, 14.387494569938159d, 9);
	}

	void check(int[] x, int a, double b, int c) {
		in.input(x.length);
		in.input(Arrays.stream(x).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(3, lines.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			assertEquals(a, scanner.nextInt());
			assertNumberIsAbout(b, scanner.nextDouble(), TOLERANCE);
			assertEquals(c, scanner.nextInt());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
