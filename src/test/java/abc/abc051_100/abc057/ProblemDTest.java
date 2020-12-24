package abc.abc051_100.abc057;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 0.000001d;

	@Test
	void case1() {
		in.input("5 2 2\n" + "1 2 3 4 5");
		ProblemD.main(null);
		String[] lines = out.toString().split("\n");
		assertEquals(2, lines.length);
		assertNumberIsAbout(lines[0], 4.5d, TOLERANCE);
		assertEquals("1", lines[1]);
	}

	@Test
	void case2() {
		in.input("4 2 3\n" + "10 20 10 10");
		ProblemD.main(null);
		String[] lines = out.toString().split("\n");
		assertEquals(2, lines.length);
		assertNumberIsAbout(lines[0], 15.0d, TOLERANCE);
		assertEquals("3", lines[1]);
	}

	@Test
	void case3() {
		in.input("5 1 5\n" + "1000000000000000 999999999999999 999999999999998 999999999999997 999999999999996");
		ProblemD.main(null);
		String[] lines = out.toString().split("\n");
		assertEquals(2, lines.length);
		assertNumberIsAbout(lines[0], 1000000000000000.0d, TOLERANCE);
		assertEquals("1", lines[1]);
	}

	@Test
	void case4() {
		in.input("50 1 50\n"
				+ "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1");
		ProblemD.main(null);
		String[] lines = out.toString().split("\n");
		assertEquals(2, lines.length);
		assertNumberIsAbout(lines[0], 1.0d, TOLERANCE);
		assertEquals("1125899906842623", lines[1]);
	}
}
