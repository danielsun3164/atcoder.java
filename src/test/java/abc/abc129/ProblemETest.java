package abc.abc129;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("10", "5");
	}

	@Test
	void case2() {
		check("1111111111111111111", "162261460");
	}

	@Test
	void case3() {
		check("100", "11");
	}
}
