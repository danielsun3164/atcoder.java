package abc.abc151_200.abc197;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

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
		String[] numbers = lines[0].split("\\ ");
		assertEquals(2, numbers.length);
		assertNumberIsAbout(ex, numbers[0], TOLERANCE);
		assertNumberIsAbout(ey, numbers[1], TOLERANCE);
	}
}
