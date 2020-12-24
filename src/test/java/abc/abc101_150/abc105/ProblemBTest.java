package abc.abc101_150.abc105;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("11", "Yes");
	}

	@Test
	void case2() {
		check("40", "Yes");
	}

	@Test
	void case3() {
		check("3", "No");
	}
}
