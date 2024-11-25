package abc.abc201_250.abc236;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class ProblemE別回答Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-3d;

	@Test
	void case1() {
		check(6, new int[] { 2, 1, 2, 1, 1, 10 }, 4.0d, 2);
	}

	@Test
	void case2() {
		check(7, new int[] { 3, 1, 4, 1, 5, 9, 2 }, 5.25d, 4);
	}

	void check(int n, int[] a, double expectedAverage, int expectedMedian) {
		in.input(n);
		in.input(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			double average = scanner.nextDouble();
			assertNumberIsAbout(expectedAverage, average, TOLERANCE);
			int median = scanner.nextInt();
			assertEquals(expectedMedian, median);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	};

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/E", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int n = inputScanner.nextInt();
				int[] a = IntStream.range(0, n).map(i -> inputScanner.nextInt()).toArray();
				double expectedAverage = expectedScanner.nextDouble();
				int expectedMedian = expectedScanner.nextInt();
				check(n, a, expectedAverage, expectedMedian);
			}
		});
	}
}
