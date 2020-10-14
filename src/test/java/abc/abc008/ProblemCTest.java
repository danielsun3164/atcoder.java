package abc.abc008;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		checkResultIsAbout("3\n" + "2\n" + "4\n" + "8", 2.166666666667d, 0.000001d);
	}

	@Test
	void case2() {
		check("4\n" + "5\n" + "5\n" + "5\n" + "5", 2.0d);
	}

	@Test
	void case3() {
		check("5\n" + "2\n" + "3\n" + "2\n" + "6\n" + "12", 3.1d);
	}
}
