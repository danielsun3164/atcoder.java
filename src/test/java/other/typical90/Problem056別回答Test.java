package other.typical90;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem056別回答Test extends TestBase {

	@Test
	void case1() {
		check(3, 34, new int[] { 3, 15, 26 }, new int[] { 14, 9, 5 });
	}

	void check(int n, int s, int[] a, int[] b) {
		in.input(n + " " + s);
		IntStream.range(0, n).forEach(i -> in.input(a[i] + " " + b[i]));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		assertEquals(n, lines[0].length());
		assertEquals(s, IntStream.range(0, n).map(i -> (lines[0].charAt(i) == 'A') ? a[i] : b[i]).sum());
	}

	@Test
	void case2() {
		check(5, 77, new int[] { 1, 3, 43, 4, 23 }, new int[] { 16, 91, 9, 26, 11 });
	}

	@Test
	void case3() {
		check("5 59\n" + "8 13\n" + "55 5\n" + "58 8\n" + "23 14\n" + "4 61", "Impossible");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/056", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			String r = expectedScanner.next();
			if ("Impossible".equals(r)) {
				check(inputIs, r);
			} else {
				int n = inputScanner.nextInt(), s = inputScanner.nextInt();
				int[] a = new int[n], b = new int[n];
				IntStream.range(0, n).forEach(i -> {
					a[i] = inputScanner.nextInt();
					b[i] = inputScanner.nextInt();
				});
				check(n, s, a, b);
			}
		}
	}
}
