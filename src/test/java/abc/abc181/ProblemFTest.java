package abc.abc181;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	private static final double TOLERANCE = 0.0001d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "0 -40\n" + "0 40", 40.0d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("4\n" + "0 -10\n" + "99 10\n" + "0 91\n" + "99 -91", 50.5d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("10\n" + "-90 40\n" + "20 -30\n" + "0 -90\n" + "10 -70\n" + "80 70\n" + "-90 30\n"
				+ "-20 -80\n" + "10 90\n" + "50 30\n" + "60 -70", 33.541019662496845446d, TOLERANCE);
	}

	@Test
	void case4() {
		checkResultIsAbout("10\n" + "65 -90\n" + "-34 -2\n" + "62 99\n" + "42 -13\n" + "47 -84\n" + "84 87\n"
				+ "16 -78\n" + "56 35\n" + "90 8\n" + "90 19", 35.003571246374276203d, TOLERANCE);
	}
}
