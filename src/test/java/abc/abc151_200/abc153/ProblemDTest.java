package abc.abc151_200.abc153;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2", "3");
	}

	@Test
	void case2() {
		check("4", "7");
	}

	@Test
	void case3() {
		check("1000000000000", "1099511627775");
	}
}
