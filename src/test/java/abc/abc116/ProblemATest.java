package abc.abc116;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 4 5", "6");
	}

	@Test
	void case2() {
		check("5 12 13", "30");
	}

	@Test
	void case3() {
		check("45 28 53", "630");
	}
}
