package abc.abc101_150.abc142;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4", 0.5d);
	}

	@Test
	void case2() {
		checkResultIsAbout("5", 0.6d, 1E-6d);
	}

	@Test
	void case3() {
		check("1", 1.0d);
	}
}
