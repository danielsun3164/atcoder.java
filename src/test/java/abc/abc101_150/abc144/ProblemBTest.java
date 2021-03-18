package abc.abc101_150.abc144;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10", "Yes");
	}

	@Test
	void case2() {
		check("50", "No");
	}

	@Test
	void case3() {
		check("81", "Yes");
	}
}
