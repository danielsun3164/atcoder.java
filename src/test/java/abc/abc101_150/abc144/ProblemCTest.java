package abc.abc101_150.abc144;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("10", "5");
	}

	@Test
	void case2() {
		check("50", "13");
	}

	@Test
	void case3() {
		check("10000000019", "10000000018");
	}
}
