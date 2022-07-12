package abc.abc151_200.abc178;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(6, new int[] { 1, 1, 1, 2, 2, 3 }, new int[] { 1, 1, 1, 2, 2, 3 });
	}

	@Test
	void case2() {
		check("3\n" + "1 1 2\n" + "1 1 3", "No");
	}

	@Test
	void case3() {
		check(4, new int[] { 1, 1, 2, 3 }, new int[] { 1, 2, 3, 3 });
	}

	private void check(int n, int[] a, int[] b) {
		in.input(n);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		in.input(Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		String[] numbers = lines[1].split("\\ ");
		assertEquals(n, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			String result = scanner.next();
			assertEquals("Yes", result);
			int[] newB = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
			// a[i]とnewB[i]が異なることを判定
			IntStream.range(0, n).forEach(i -> assertNotEquals(a[i], newB[i]));
			// bとnewBは同じものを判定
			Arrays.sort(b);
			Arrays.sort(newB);
			assertArrayEquals(b, newB);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC178/F", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			String result = expectedScanner.next();
			if ("No".equals(result)) {
				check(inputIs, result);
			} else {
				int n = inputScanner.nextInt();
				int[] a = IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray();
				int[] b = IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray();
				check(n, a, b);
			}
		}
	}
}
