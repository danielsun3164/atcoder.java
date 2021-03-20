package abc.abc101_150.abc140;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6 1\n" + "LRLRRL", "3");
	}

	@Test
	void case2() {
		check("13 3\n" + "LRRLRLRRLRLLR", "9");
	}

	@Test
	void case3() {
		check("10 1\n" + "LLLLLRRRRR", "9");
	}

	@Test
	void case4() {
		check("9 2\n" + "RRRLRLRLL", "7");
	}
}
