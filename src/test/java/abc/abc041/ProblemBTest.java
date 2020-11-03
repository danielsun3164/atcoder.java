package abc.abc041;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3 4", "24");
	}

	@Test
	void case2() {
		check("10000 1000 100", "1000000000");
	}

	@Test
	void case3() {
		check("100000 1 100000", "999999937");
	}

	@Test
	void case4() {
		check("1000000000 1000000000 1000000000", "999999664");
	}
}
