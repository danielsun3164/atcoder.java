package abc.abc001_050.abc007;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1 9", "2");
	}

	@Test
	void case2() {
		check("40 49", "10");
	}

	@Test
	void case3() {
		check("1 1000", "488");
	}

	@Test
	void case4() {
		check("1 1000000000000000000", "981985601490518016");
	}
}
