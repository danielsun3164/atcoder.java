package abc.abc169;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("24", "3");
	}

	@Test
	void case2() {
		check("1", "0");
	}

	@Test
	void case3() {
		check("64", "3");
	}

	@Test
	void case4() {
		check("1000000007", "1");
	}
}
