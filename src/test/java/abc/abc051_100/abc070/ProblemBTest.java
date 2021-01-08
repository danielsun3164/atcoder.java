package abc.abc051_100.abc070;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("0 75 25 100", "50");
	}

	@Test
	void case2() {
		check("0 33 66 99", "0");
	}

	@Test
	void case3() {
		check("10 90 20 80", "60");
	}
}
