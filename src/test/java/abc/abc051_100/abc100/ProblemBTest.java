package abc.abc051_100.abc100;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("0 5", "5");
	}

	@Test
	void case2() {
		check("1 11", "1100");
	}

	@Test
	void case3() {
		check("2 85", "850000");
	}
}
