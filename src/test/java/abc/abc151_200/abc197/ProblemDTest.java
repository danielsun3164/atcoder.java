package abc.abc151_200.abc197;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Scanner;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-5d;

	@Test
	void case1() {
		check(4, 1, 1, 2, 2, 2.0d, 1.0d);
	}

	@Test
	void case2() {
		check(6, 5, 3, 7, 4, 5.93301270189d, 2.38397459622d);
	}

	@Test
	void case3() {
		check(4, 1, 1, 1, 2, 1.5d, 1.5d);
	}

	@Test
	void case4() {
		check(4, 1, 1, 0, 2, 1.0d, 2.0d);
	}

	@Test
	void case5() {
		check(4, 1, 1, 0, 0, 0.0d, 1.0d);
	}

	@Test
	void case6() {
		check(4, 1, 1, 0, 2, 1.0d, 2.0d);
	}

	void check(int n, int x0, int y0, int xn2, int yn2, double ex, double ey) {
		in.input(n);
		in.input(x0 + " " + y0);
		in.input(xn2 + " " + yn2);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\s+");
		assertEquals(2, numbers.length);
		assertNumberIsAbout(ex, numbers[0], TOLERANCE);
		assertNumberIsAbout(ey, numbers[1], TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC197/D", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int n = inputScanner.nextInt();
				int x0 = inputScanner.nextInt(), y0 = inputScanner.nextInt();
				int xn2 = inputScanner.nextInt(), yn2 = inputScanner.nextInt();
				double ex = expectedScanner.nextDouble(), ey = expectedScanner.nextDouble();
				check(n, x0, y0, xn2, yn2, ex, ey);
			}
		});
	}
}
