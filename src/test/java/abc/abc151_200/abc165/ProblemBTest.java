package abc.abc151_200.abc165;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("103", "3");
	}

	@Test
	void case2() {
		check("1000000000000000000", "3760");
	}

	@Test
	void case3() {
		check("1333333333", "1706");
	}
}
