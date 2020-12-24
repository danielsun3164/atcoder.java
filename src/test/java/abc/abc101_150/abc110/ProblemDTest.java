package abc.abc101_150.abc110;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 6", "4");
	}

	@Test
	void case2() {
		check("3 12", "18");
	}

	@Test
	void case3() {
		check("100000 1000000000", "957870001");
	}
}
