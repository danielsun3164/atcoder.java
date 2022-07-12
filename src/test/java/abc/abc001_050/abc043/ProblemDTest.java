package abc.abc001_050.abc043;

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

class ProblemDTest extends TestBase {

	/** 小文字のアルファベットの数 */
	private static final int N = 26;

	@Test
	void case1() {
		check("needed");
	}

	void check(String input) {
		in.input(input);
		char[] s = input.toCharArray();
		int n = s.length;
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\ ");
		assertEquals(2, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int a = scanner.nextInt() - 1, b = scanner.nextInt() - 1;
			assertTrue((a >= 0) && (a < n));
			assertTrue((b >= 0) && (b < n));
			assertTrue(b - a + 1 >= 2);
			int[] count = new int[N];
			Arrays.fill(count, 0);
			IntStream.rangeClosed(a, b).forEach(i -> count[s[i] - 'a']++);
			assertTrue(Arrays.stream(count).max().getAsInt() > (b - a + 1) / 2);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			int a = expectedScanner.nextInt(), b = expectedScanner.nextInt();
			if ((-1 == a) && (-1 == b)) {
				check(inScanner.next(), "-1 -1");
			} else {
				check(inScanner.next());
			}
		}
	}

	@Test
	void case2() {
		check("atcoder", "-1 -1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC059_ABC043/D", this::check);
	}
}
