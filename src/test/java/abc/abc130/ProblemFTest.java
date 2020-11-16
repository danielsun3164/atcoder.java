package abc.abc130;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-9d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "0 3 D\n" + "3 0 L", 0.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("5\n" + "-7 -10 U\n" + "7 -6 U\n" + "-8 7 D\n" + "-3 3 D\n" + "0 -6 R", 97.5d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("20\n" + "6 -10 R\n" + "-4 -9 U\n" + "9 6 D\n" + "-3 -2 R\n" + "0 7 D\n" + "4 5 D\n"
				+ "10 -10 U\n" + "-1 -8 U\n" + "10 -6 D\n" + "8 -5 U\n" + "6 4 D\n" + "0 3 D\n" + "7 9 R\n" + "9 -4 R\n"
				+ "3 10 D\n" + "1 9 U\n" + "1 -6 U\n" + "9 -8 R\n" + "6 7 D\n" + "7 -3 D", 273.0d, TOLERANCE);
	}

	@Test
	void case4() {
		checkResultIsAbout(
				"20\n" + "-666 -771 R\n" + "-273 -586 R\n" + "-925 -685 R\n" + "110 939 R\n" + "81 237 R\n"
						+ "-418 506 R\n" + "543 405 R\n" + "209 -210 R\n" + "-275 -940 R\n" + "-819 -931 R\n"
						+ "-305 -519 R\n" + "458 146 R\n" + "890 -320 R\n" + "357 185 R\n" + "317 552 R\n"
						+ "-159 -52 R\n" + "-827 -95 R\n" + "219 912 R\n" + "881 147 R\n" + "392 -346 R",
				3410385.0d, TOLERANCE);
	}
}
