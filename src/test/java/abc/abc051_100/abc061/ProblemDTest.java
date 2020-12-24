package abc.abc051_100.abc061;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2 4\n" + "2 3 3\n" + "1 3 5", "7");
	}

	@Test
	void case2() {
		check("2 2\n" + "1 2 1\n" + "2 1 1", "inf");
	}

	@Test
	void case3() {
		check("6 5\n" + "1 2 -1000000000\n" + "2 3 -1000000000\n" + "3 4 -1000000000\n" + "4 5 -1000000000\n"
				+ "5 6 -1000000000", "-5000000000");
	}
}
