package abc.abc001_050.abc011;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 10000000\n" + "10000000 10000000", 0.125d);
	}

	@Test
	void case2() {
		check("100 2\n" + "3 7", 0.0d);
	}

	@Test
	void case3() {
		checkResultIsAbout("11 8562174\n" + "25686522 17124348", 0.018174648284912d, 0.000000001d);
	}
}
