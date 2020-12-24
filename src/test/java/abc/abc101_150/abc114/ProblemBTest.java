package abc.abc101_150.abc114;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1234567876", "34");
	}

	@Test
	void case2() {
		check("35753", "0");
	}

	@Test
	void case3() {
		check("1111111111", "642");
	}
}
