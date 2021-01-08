package abc.abc101_150.abc130;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 10\n" + "6 1 2 7", "2");
	}

	@Test
	void case2() {
		check("3 5\n" + "3 3 3", "3");
	}

	@Test
	void case3() {
		check("10 53462\n" + "103 35322 232 342 21099 90000 18843 9010 35221 19352", "36");
	}
}
